
import jakarta.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.EkipmanBakim;
import model.TeknikDestek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EkipmanBakimRepository;

@Service
public class TeknikDestekService {

    @Autowired
    private TeknikDestekRepository teknikDestekRepository;

    @Autowired
    private EkipmanBakimRepository ekipmanBakimRepository;

    // Save Teknik Destek
    @Transactional
    public TeknikDestekDTO saveTeknikDestek(TeknikDestekDTO teknikDestekDTO) {
        Set<EkipmanBakim> ekipmanBakimlar = new HashSet<>();
        for (Long ekipmanBakimId : teknikDestekDTO.getEkipmanBakimIds()) {
            EkipmanBakim ekipmanBakim = ekipmanBakimRepository.findById(ekipmanBakimId)
                    .orElseThrow(() -> new RuntimeException("Ekipman Bakım bulunamadı"));
            ekipmanBakimlar.add(ekipmanBakim);
        }

        TeknikDestek teknikDestek = new TeknikDestek();
        teknikDestek.setKullaniciAdi(teknikDestekDTO.getKullaniciAdi());
        teknikDestek.setEkipmanBakimlar(ekipmanBakimlar);  // Bu satırdaki hata düzeltilmiştir

        teknikDestekRepository.save(teknikDestek);

        return mapToDTO(teknikDestek);
    }

    // Get All Teknik Destek
    public List<TeknikDestekDTO> getAllTeknikDestek() {
        return teknikDestekRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get Teknik Destek by ID
    public TeknikDestekDTO getTeknikDestekById(Long id) {
        TeknikDestek teknikDestek = teknikDestekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teknik Destek bulunamadı"));
        return mapToDTO(teknikDestek);
    }

    // Update Teknik Destek
    @Transactional
    public TeknikDestekDTO updateTeknikDestek(Long id, TeknikDestekDTO teknikDestekDTO) {
        TeknikDestek existingTeknikDestek = teknikDestekRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teknik Destek bulunamadı"));

        existingTeknikDestek.setKullaniciAdi(teknikDestekDTO.getKullaniciAdi());  // Bu satırdaki hata düzeltilmiştir

        // Update Ekipman Bakım ilişkileri
        Set<EkipmanBakim> ekipmanBakimlar = new HashSet<>();
        for (Long ekipmanBakimId : teknikDestekDTO.getEkipmanBakimIds()) {
            EkipmanBakim ekipmanBakim = ekipmanBakimRepository.findById(ekipmanBakimId)
                    .orElseThrow(() -> new RuntimeException("Ekipman Bakım bulunamadı"));
            ekipmanBakimlar.add(ekipmanBakim);
        }
        existingTeknikDestek.setEkipmanBakimlar(ekipmanBakimlar);  // Bu satırdaki hata düzeltilmiştir

        teknikDestekRepository.save(existingTeknikDestek);

        return mapToDTO(existingTeknikDestek);
    }

    // Delete Teknik Destek
    @Transactional
    public void deleteTeknikDestek(Long id) {
        teknikDestekRepository.deleteById(id);
    }

    // Map TeknikDestek entity to DTO
    private TeknikDestekDTO mapToDTO(TeknikDestek teknikDestek) {
        Set<Long> ekipmanBakimIds = new HashSet<>();
        for (EkipmanBakim ekipmanBakim : teknikDestek.getEkipmanBakimlar()) {
            ekipmanBakimIds.add(ekipmanBakim.getId());
        }
        return new TeknikDestekDTO(
            teknikDestek.getId(),
            teknikDestek.getKullaniciAdi(),  // Bu satırdaki hata düzeltilmiştir
            ekipmanBakimIds
        );
    }
}

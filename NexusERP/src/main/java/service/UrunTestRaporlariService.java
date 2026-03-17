package service;

import dto.UrunTestRaporlariDTO;
import model.EkipmanBakim;
import model.UrunTestRaporlari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EkipmanBakimRepository;
import repository.UrunTestRaporlariRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrunTestRaporlariService {

    private final UrunTestRaporlariRepository urunTestRaporlariRepository;
    private final EkipmanBakimRepository ekipmanBakimRepository;

    @Autowired
    public UrunTestRaporlariService(UrunTestRaporlariRepository urunTestRaporlariRepository, EkipmanBakimRepository ekipmanBakimRepository) {
        this.urunTestRaporlariRepository = urunTestRaporlariRepository;
        this.ekipmanBakimRepository = ekipmanBakimRepository;
    }

    // Yeni bir test raporu oluşturma
    @Transactional
    public void createUrunTestRapor(UrunTestRaporlariDTO urunTestRaporlariDTO) {
        UrunTestRaporlari urunTestRaporlari = new UrunTestRaporlari();
        urunTestRaporlari.setUrunAdi(urunTestRaporlariDTO.getUrunAdi());
        urunTestRaporlari.setTestSonucu(urunTestRaporlariDTO.getTestSonucu());
        urunTestRaporlari.setTestTarihi(urunTestRaporlariDTO.getTestTarihi());
        urunTestRaporlari.setRaporDetayi(urunTestRaporlariDTO.getRaporDetayi());

        // EkipmanBakim'ı ilişkilendiriyoruz
        EkipmanBakim ekipmanBakim = ekipmanBakimRepository.findById(urunTestRaporlariDTO.getEkipmanBakimId())
                .orElseThrow(() -> new RuntimeException("Ekipman bakımı bulunamadı"));

        urunTestRaporlari.setEkipmanBakim(ekipmanBakim);

        urunTestRaporlariRepository.save(urunTestRaporlari);
    }

    public boolean updateUrunTestRapor(Long id, UrunTestRaporlariDTO urunTestRaporlariDTO) {
        Optional<UrunTestRaporlari> raporOpt = urunTestRaporlariRepository.findById(id);
        if (raporOpt.isPresent()) {
            UrunTestRaporlari rapor = raporOpt.get();
            rapor.setUrunAdi(urunTestRaporlariDTO.getUrunAdi());
            rapor.setTestSonucu(urunTestRaporlariDTO.getTestSonucu());
            rapor.setTestTarihi(urunTestRaporlariDTO.getTestTarihi());
            rapor.setRaporDetayi(urunTestRaporlariDTO.getRaporDetayi());
            urunTestRaporlariRepository.save(rapor);
            return true;
        }
        return false;
    }

    public boolean deleteUrunTestRapor(Long id) {
        Optional<UrunTestRaporlari> raporOpt = urunTestRaporlariRepository.findById(id);
        if (raporOpt.isPresent()) {
            urunTestRaporlariRepository.delete(raporOpt.get());
            return true;
        }
        return false;
    }

    // Servis Katmanındaki getAllUrunTestRaporlari
    public List<UrunTestRaporlariDTO> getAllUrunTestRaporlari() {
        List<UrunTestRaporlari> raporlar = urunTestRaporlariRepository.findAll();
        return raporlar.stream()
                .map(rapor -> new UrunTestRaporlariDTO(
                        rapor.getId(),
                        rapor.getUrunAdi(),
                        rapor.getTestSonucu(),
                        rapor.getTestTarihi(),
                        rapor.getRaporDetayi(),
                        rapor.getEkipmanBakim() != null ? rapor.getEkipmanBakim().getId() : null // EkipmanBakim ID'sini ekliyoruz
                ))
                .collect(Collectors.toList());
    }

    // Servis Katmanındaki getUrunTestRaporById
    public UrunTestRaporlariDTO getUrunTestRaporById(Long id) {
        Optional<UrunTestRaporlari> raporOpt = urunTestRaporlariRepository.findById(id);
        if (raporOpt.isPresent()) {
            UrunTestRaporlari rapor = raporOpt.get();
            return new UrunTestRaporlariDTO(
                    rapor.getId(),
                    rapor.getUrunAdi(),
                    rapor.getTestSonucu(),
                    rapor.getTestTarihi(),
                    rapor.getRaporDetayi(),
                    rapor.getEkipmanBakim() != null ? rapor.getEkipmanBakim().getId() : null // EkipmanBakim ID'sini ekliyoruz
            );
        }
        return null; // Eğer rapor bulunamazsa null döner
    }

    // Diğer metotlar...
}

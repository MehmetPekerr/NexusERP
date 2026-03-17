package service;

import com.example.mimari.repository.UrunTanitimPlanlariRepository;
import dto.UrunlerDTO;
import dto.UrunTanitimPlanlariDTO;
import model.Urunler;
import model.UrunTanitimPlanlari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UrunlerRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UrunTanitimPlanlariService {

    private final UrunTanitimPlanlariRepository tanitimPlanlariRepository;
    private final UrunlerRepository urunRepository;

    @Autowired
    public UrunTanitimPlanlariService(UrunTanitimPlanlariRepository tanitimPlanlariRepository, UrunlerRepository urunRepository) {
        this.tanitimPlanlariRepository = tanitimPlanlariRepository;
        this.urunRepository = urunRepository;
    }

    // Ürün tanıtım planı oluşturma
    @Transactional
    public void createUrunTanitimPlani(UrunTanitimPlanlariDTO dto) {
        UrunTanitimPlanlari tanitimPlani = new UrunTanitimPlanlari();
        tanitimPlani.setTanitimTuru(dto.getTanitimTuru());
        tanitimPlani.setHedefKitlesi(dto.getHedefKitlesi());
        tanitimPlani.setBaslangicTarihi(dto.getBaslangicTarihi());
        tanitimPlani.setBitisTarihi(dto.getBitisTarihi());
        tanitimPlani.setStrateji(dto.getStrateji());

        // DTO'dan gelen Urunler'i bulup ilişkilendiriyoruz
        Set<Urunler> urunler = dto.getUrunler().stream()
                .map(urunDTO -> urunRepository.findById(urunDTO.getId())
                        .orElseThrow(() -> new RuntimeException("Urun bulunamadı: " + urunDTO.getId())))
                .collect(Collectors.toSet());

        tanitimPlani.setUrunler(urunler);
        tanitimPlanlariRepository.save(tanitimPlani);
    }

    // Tüm ürün tanıtım planlarını döndürme
    public List<UrunTanitimPlanlariDTO> getAllUrunTanitimPlanlari() {
        List<UrunTanitimPlanlari> tanitimPlanlariList = tanitimPlanlariRepository.findAll();

        return tanitimPlanlariList.stream().map(tanitimPlani -> {
            Set<UrunlerDTO> urunlerDTOs = tanitimPlani.getUrunler().stream()
                    .map(urunler -> new UrunlerDTO(
                            urunler.getId(),
                            urunler.getUrunAdi(),
                            urunler.getUrunKodu(),
                            urunler.getFiyat(), // Yeni alanları da ekliyoruz
                            urunler.getStokMiktari()))
                    .collect(Collectors.toSet());

            return new UrunTanitimPlanlariDTO(
                    tanitimPlani.getId(),
                    tanitimPlani.getTanitimTuru(),
                    tanitimPlani.getHedefKitlesi(),
                    tanitimPlani.getBaslangicTarihi(),
                    tanitimPlani.getBitisTarihi(),
                    tanitimPlani.getStrateji(),
                    urunlerDTOs
            );
        }).collect(Collectors.toList());
    }

    // ID ile bir ürün tanıtım planı getirme
    public UrunTanitimPlanlariDTO getUrunTanitimPlaniById(Long id) {
        Optional<UrunTanitimPlanlari> tanitimPlaniOpt = tanitimPlanlariRepository.findById(id);

        if (tanitimPlaniOpt.isPresent()) {
            UrunTanitimPlanlari tanitimPlani = tanitimPlaniOpt.get();
            Set<UrunlerDTO> urunlerDTOs = tanitimPlani.getUrunler().stream()
                    .map(urunler -> new UrunlerDTO(
                            urunler.getId(),
                            urunler.getUrunAdi(),
                            urunler.getUrunKodu(),
                            urunler.getFiyat(),  // Yeni alanları da ekliyoruz
                            urunler.getStokMiktari())) 
                    .collect(Collectors.toSet());

            return new UrunTanitimPlanlariDTO(
                    tanitimPlani.getId(),
                    tanitimPlani.getTanitimTuru(),
                    tanitimPlani.getHedefKitlesi(),
                    tanitimPlani.getBaslangicTarihi(),
                    tanitimPlani.getBitisTarihi(),
                    tanitimPlani.getStrateji(),
                    urunlerDTOs
            );
        } else {
            return null; // Plan bulunamadı
        }
    }

    // Ürün tanıtım planını güncelleme
    @Transactional
    public boolean updateUrunTanitimPlani(Long id, UrunTanitimPlanlariDTO dto) {
        Optional<UrunTanitimPlanlari> tanitimPlaniOpt = tanitimPlanlariRepository.findById(id);

        if (tanitimPlaniOpt.isPresent()) {
            UrunTanitimPlanlari tanitimPlani = tanitimPlaniOpt.get();
            tanitimPlani.setTanitimTuru(dto.getTanitimTuru());
            tanitimPlani.setHedefKitlesi(dto.getHedefKitlesi());
            tanitimPlani.setBaslangicTarihi(dto.getBaslangicTarihi());
            tanitimPlani.setBitisTarihi(dto.getBitisTarihi());
            tanitimPlani.setStrateji(dto.getStrateji());

            // DTO'dan gelen Urunler'i güncelliyoruz
            Set<Urunler> urunler = dto.getUrunler().stream()
                    .map(urunDTO -> urunRepository.findById(urunDTO.getId())
                            .orElseThrow(() -> new RuntimeException("Urun bulunamadı: " + urunDTO.getId())))
                    .collect(Collectors.toSet());

            tanitimPlani.setUrunler(urunler);
            tanitimPlanlariRepository.save(tanitimPlani);
            return true;
        } else {
            return false; // Plan bulunamadı
        }
    }

    // Ürün tanıtım planını silme
    @Transactional
    public boolean deleteUrunTanitimPlani(Long id) {
        Optional<UrunTanitimPlanlari> tanitimPlaniOpt = tanitimPlanlariRepository.findById(id);

        if (tanitimPlaniOpt.isPresent()) {
            tanitimPlanlariRepository.delete(tanitimPlaniOpt.get());
            return true;
        } else {
            return false; // Plan bulunamadı
        }
    }
}

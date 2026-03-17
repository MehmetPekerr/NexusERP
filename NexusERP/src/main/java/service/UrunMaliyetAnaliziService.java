package service;

import dto.UrunMaliyetAnaliziDTO;
import model.UrunMaliyetAnalizi;
import model.UrunEldeEtmeSureci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UrunMaliyetAnaliziRepository;
import repository.UrunEldeEtmeSureciRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrunMaliyetAnaliziService {

    private final UrunMaliyetAnaliziRepository urunMaliyetAnaliziRepository;
    private final UrunEldeEtmeSureciRepository urunEldeEtmeSureciRepository;

    @Autowired
    public UrunMaliyetAnaliziService(UrunMaliyetAnaliziRepository urunMaliyetAnaliziRepository, UrunEldeEtmeSureciRepository urunEldeEtmeSureciRepository) {
        this.urunMaliyetAnaliziRepository = urunMaliyetAnaliziRepository;
        this.urunEldeEtmeSureciRepository = urunEldeEtmeSureciRepository;
    }

    // Yeni bir ürün maliyet analizi oluşturma
    @Transactional
    public void createUrunMaliyetAnalizi(UrunMaliyetAnaliziDTO urunMaliyetAnaliziDTO) {
        UrunMaliyetAnalizi urunMaliyetAnalizi = new UrunMaliyetAnalizi();
        urunMaliyetAnalizi.setUrunAdi(urunMaliyetAnaliziDTO.getUrunAdi());
        urunMaliyetAnalizi.setUretimMaliyeti(urunMaliyetAnaliziDTO.getUretimMaliyeti());
        urunMaliyetAnalizi.setLojistikMaliyeti(urunMaliyetAnaliziDTO.getLojistikMaliyeti());
        urunMaliyetAnalizi.setDigerMaliyetler(urunMaliyetAnaliziDTO.getDigerMaliyetler());
        urunMaliyetAnalizi.setToplamMaliyet(urunMaliyetAnaliziDTO.getToplamMaliyet());
        urunMaliyetAnalizi.setTarih(urunMaliyetAnaliziDTO.getTarih());

        // UrunEldeEtmeSureci ile ilişki kuruluyor
        List<UrunEldeEtmeSureci> urunEldeEtmeSureciList = urunEldeEtmeSureciRepository.findAllById(urunMaliyetAnaliziDTO.getUrunEldeEtmeSureciIdListesi());
        urunMaliyetAnalizi.setUrunEldeEtmeSureci(urunEldeEtmeSureciList);

        urunMaliyetAnaliziRepository.save(urunMaliyetAnalizi);
    }

    // Tüm ürün maliyet analizlerini listeleme
    public List<UrunMaliyetAnaliziDTO> getAllUrunMaliyetAnalizleri() {
        List<UrunMaliyetAnalizi> urunMaliyetAnaliziList = urunMaliyetAnaliziRepository.findAll();
        return urunMaliyetAnaliziList.stream()
                .map(urunMaliyetAnalizi -> new UrunMaliyetAnaliziDTO(
                        urunMaliyetAnalizi.getId(),
                        urunMaliyetAnalizi.getUrunAdi(),
                        urunMaliyetAnalizi.getUretimMaliyeti(),
                        urunMaliyetAnalizi.getLojistikMaliyeti(),
                        urunMaliyetAnalizi.getDigerMaliyetler(),
                        urunMaliyetAnalizi.getToplamMaliyet(),
                        urunMaliyetAnalizi.getTarih(),
                        urunMaliyetAnalizi.getUrunEldeEtmeSureci().stream()
                                .map(UrunEldeEtmeSureci::getId)
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    // ID ile bir ürün maliyet analizini getirme
    public UrunMaliyetAnaliziDTO getUrunMaliyetAnaliziById(Long id) {
        Optional<UrunMaliyetAnalizi> urunMaliyetAnalizi = urunMaliyetAnaliziRepository.findById(id);
        if (urunMaliyetAnalizi.isPresent()) {
            UrunMaliyetAnalizi u = urunMaliyetAnalizi.get();
            return new UrunMaliyetAnaliziDTO(
                    u.getId(),
                    u.getUrunAdi(),
                    u.getUretimMaliyeti(),
                    u.getLojistikMaliyeti(),
                    u.getDigerMaliyetler(),
                    u.getToplamMaliyet(),
                    u.getTarih(),
                    u.getUrunEldeEtmeSureci().stream()
                            .map(UrunEldeEtmeSureci::getId)
                            .collect(Collectors.toList())
            );
        } else {
            throw new RuntimeException("Ürün maliyet analizi bulunamadı");
        }
    }

    // Ürün maliyet analizini güncelleme
    @Transactional
    public void updateUrunMaliyetAnalizi(Long id, UrunMaliyetAnaliziDTO urunMaliyetAnaliziDTO) {
        Optional<UrunMaliyetAnalizi> urunMaliyetAnaliziOpt = urunMaliyetAnaliziRepository.findById(id);
        if (urunMaliyetAnaliziOpt.isPresent()) {
            UrunMaliyetAnalizi urunMaliyetAnalizi = urunMaliyetAnaliziOpt.get();
            urunMaliyetAnalizi.setUrunAdi(urunMaliyetAnaliziDTO.getUrunAdi());
            urunMaliyetAnalizi.setUretimMaliyeti(urunMaliyetAnaliziDTO.getUretimMaliyeti());
            urunMaliyetAnalizi.setLojistikMaliyeti(urunMaliyetAnaliziDTO.getLojistikMaliyeti());
            urunMaliyetAnalizi.setDigerMaliyetler(urunMaliyetAnaliziDTO.getDigerMaliyetler());
            urunMaliyetAnalizi.setToplamMaliyet(urunMaliyetAnaliziDTO.getToplamMaliyet());
            urunMaliyetAnalizi.setTarih(urunMaliyetAnaliziDTO.getTarih());

            // UrunEldeEtmeSureci ile ilişki güncelleniyor
            List<UrunEldeEtmeSureci> urunEldeEtmeSureciList = urunEldeEtmeSureciRepository.findAllById(urunMaliyetAnaliziDTO.getUrunEldeEtmeSureciIdListesi());
            urunMaliyetAnalizi.setUrunEldeEtmeSureci(urunEldeEtmeSureciList);

            urunMaliyetAnaliziRepository.save(urunMaliyetAnalizi);
        } else {
            throw new RuntimeException("Ürün maliyet analizi bulunamadı");
        }
    }

    // Ürün maliyet analizini silme
    @Transactional
    public void deleteUrunMaliyetAnalizi(Long id) {
        Optional<UrunMaliyetAnalizi> urunMaliyetAnaliziOpt = urunMaliyetAnaliziRepository.findById(id);
        urunMaliyetAnaliziOpt.ifPresent(urunMaliyetAnaliziRepository::delete);
    }
}

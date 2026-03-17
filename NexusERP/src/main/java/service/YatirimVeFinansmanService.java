package service;

import dto.YatirimVeFinansmanDTO;
import model.YatirimVeFinansman;
import model.Firma;  // Firma modelini import ediyoruz
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.YatirimVeFinansmanRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class YatirimVeFinansmanService {

    private final YatirimVeFinansmanRepository yatirimVeFinansmanRepository;

    @Autowired
    public YatirimVeFinansmanService(YatirimVeFinansmanRepository yatirimVeFinansmanRepository) {
        this.yatirimVeFinansmanRepository = yatirimVeFinansmanRepository;
    }

    // Yeni bir yatırım ve finansman kaydı oluşturma
    @Transactional
    public void createYatirimVeFinansman(YatirimVeFinansmanDTO yatirimVeFinansmanDTO) {
        YatirimVeFinansman yatirimVeFinansman = new YatirimVeFinansman();
        yatirimVeFinansman.setYatirimAdi(yatirimVeFinansmanDTO.getYatirimAdi());
        yatirimVeFinansman.setFinansmanKaynagi(yatirimVeFinansmanDTO.getFinansmanKaynagi());
        yatirimVeFinansman.setYatirimMiktari(yatirimVeFinansmanDTO.getYatirimMiktari());
        yatirimVeFinansman.setFinansmanDurumu(yatirimVeFinansmanDTO.getFinansmanDurumu());

        // Firma'yı da ekliyoruz
        Firma firma = new Firma();
        firma.setId(yatirimVeFinansmanDTO.getFirmaId());  // Firma id'sini DTO'dan alıyoruz
        yatirimVeFinansman.setFirma(firma);

        yatirimVeFinansmanRepository.save(yatirimVeFinansman);
    }

    // Tüm yatırım ve finansman kayıtlarını listeleme
    public List<YatirimVeFinansmanDTO> getAllYatirimVeFinansman() {
        List<YatirimVeFinansman> yatirimVeFinansmanList = yatirimVeFinansmanRepository.findAll();
        return yatirimVeFinansmanList.stream()
                .map(yatirim -> new YatirimVeFinansmanDTO(
                        yatirim.getId(),
                        yatirim.getYatirimAdi(),
                        yatirim.getFinansmanKaynagi(),
                        yatirim.getYatirimMiktari(),
                        yatirim.getFinansmanDurumu(),
                        yatirim.getFirma().getId()  // Firma ID'sini DTO'ya ekliyoruz
                ))
                .collect(Collectors.toList());
    }

    // Firma ID'sine göre yatırım ve finansmanları listeleme
    public List<YatirimVeFinansmanDTO> getYatirimVeFinansmanByFirmaId(Long firmaId) {
        List<YatirimVeFinansman> yatirimVeFinansmanList = yatirimVeFinansmanRepository.findByFirma_Id(firmaId);
        return yatirimVeFinansmanList.stream()
                .map(yatirim -> new YatirimVeFinansmanDTO(
                        yatirim.getId(),
                        yatirim.getYatirimAdi(),
                        yatirim.getFinansmanKaynagi(),
                        yatirim.getYatirimMiktari(),
                        yatirim.getFinansmanDurumu(),
                        yatirim.getFirma().getId()  // Firma ID'sini DTO'ya ekliyoruz
                ))
                .collect(Collectors.toList());
    }

    // ID ile yatırım ve finansman kaydını bulma
    public YatirimVeFinansmanDTO getYatirimVeFinansmanById(Long id) {
        Optional<YatirimVeFinansman> yatirimVeFinansman = yatirimVeFinansmanRepository.findById(id);
        if (yatirimVeFinansman.isPresent()) {
            YatirimVeFinansman yatirim = yatirimVeFinansman.get();
            return new YatirimVeFinansmanDTO(
                    yatirim.getId(),
                    yatirim.getYatirimAdi(),
                    yatirim.getFinansmanKaynagi(),
                    yatirim.getYatirimMiktari(),
                    yatirim.getFinansmanDurumu(),
                    yatirim.getFirma().getId()  // Firma ID'sini DTO'ya ekliyoruz
            );
        } else {
            throw new RuntimeException("Yatırım ve finansman kaydı bulunamadı");
        }
    }

    // Yatırım ve finansman kaydını güncelleme
    @Transactional
    public void updateYatirimVeFinansman(Long id, YatirimVeFinansmanDTO yatirimVeFinansmanDTO) {
        Optional<YatirimVeFinansman> yatirimVeFinansmanOpt = yatirimVeFinansmanRepository.findById(id);
        if (yatirimVeFinansmanOpt.isPresent()) {
            YatirimVeFinansman yatirimVeFinansman = yatirimVeFinansmanOpt.get();
            yatirimVeFinansman.setYatirimAdi(yatirimVeFinansmanDTO.getYatirimAdi());
            yatirimVeFinansman.setFinansmanKaynagi(yatirimVeFinansmanDTO.getFinansmanKaynagi());
            yatirimVeFinansman.setYatirimMiktari(yatirimVeFinansmanDTO.getYatirimMiktari());
            yatirimVeFinansman.setFinansmanDurumu(yatirimVeFinansmanDTO.getFinansmanDurumu());
            yatirimVeFinansmanRepository.save(yatirimVeFinansman);
        } else {
            throw new RuntimeException("Yatırım ve finansman kaydı bulunamadı");
        }
    }

    // Yatırım ve finansman kaydını silme
    @Transactional
    public void deleteYatirimVeFinansman(Long id) {
        Optional<YatirimVeFinansman> yatirimVeFinansmanOpt = yatirimVeFinansmanRepository.findById(id);
        if (yatirimVeFinansmanOpt.isPresent()) {
            yatirimVeFinansmanRepository.delete(yatirimVeFinansmanOpt.get());
        } else {
            throw new RuntimeException("Yatırım ve finansman kaydı bulunamadı");
        }
    }
    
    
    
}

package service;

import dto.SatisStratejileriDTO;
import model.SatisStratejileri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SatisStratejileriRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SatisStratejileriService {

    private final SatisStratejileriRepository satisStratejileriRepository;

    @Autowired
    public SatisStratejileriService(SatisStratejileriRepository satisStratejileriRepository) {
        this.satisStratejileriRepository = satisStratejileriRepository;
    }

    // Yeni bir satış stratejisi oluşturma
    @Transactional
    public void createSatisStratejisi(SatisStratejileriDTO satisStratejileriDTO) {
        SatisStratejileri satisStratejileri = new SatisStratejileri();
        satisStratejileri.setStratejiAdi(satisStratejileriDTO.getStratejiAdi());
        satisStratejileri.setAciklama(satisStratejileriDTO.getAciklama());
        
        satisStratejileriRepository.save(satisStratejileri);
    }

    // Tüm satış stratejilerini listeleme
    public List<SatisStratejileriDTO> getAllSatisStratejileri() {
        List<SatisStratejileri> satisStratejileriList = satisStratejileriRepository.findAll();
        return satisStratejileriList.stream()
                .map(satisStratejileri -> new SatisStratejileriDTO(
                        satisStratejileri.getId(),
                        satisStratejileri.getStratejiAdi(),
                        satisStratejileri.getAciklama()
                ))
                .collect(Collectors.toList());
    }

    // ID ile bir satış stratejisi bulma
    public SatisStratejileriDTO getSatisStratejisiById(Long id) {
        Optional<SatisStratejileri> satisStratejisi = satisStratejileriRepository.findById(id);
        if (satisStratejisi.isPresent()) {
            SatisStratejileri strateji = satisStratejisi.get();
            return new SatisStratejileriDTO(
                    strateji.getId(),
                    strateji.getStratejiAdi(),
                    strateji.getAciklama()
            );
        } else {
            throw new RuntimeException("Satış stratejisi bulunamadı");
        }
    }

    // Satış stratejisini güncelleme
    @Transactional
    public void updateSatisStratejisi(Long id, SatisStratejileriDTO satisStratejileriDTO) {
        Optional<SatisStratejileri> satisStratejisiOpt = satisStratejileriRepository.findById(id);
        if (satisStratejisiOpt.isPresent()) {
            SatisStratejileri satisStratejisi = satisStratejisiOpt.get();
            satisStratejisi.setStratejiAdi(satisStratejileriDTO.getStratejiAdi());
            satisStratejisi.setAciklama(satisStratejileriDTO.getAciklama());
            satisStratejileriRepository.save(satisStratejisi);
        } else {
            throw new RuntimeException("Satış stratejisi bulunamadı");
        }
    }

    // Satış stratejisini silme
    @Transactional
    public void deleteSatisStratejisi(Long id) {
        Optional<SatisStratejileri> satisStratejisiOpt = satisStratejileriRepository.findById(id);
        if (satisStratejisiOpt.isPresent()) {
            satisStratejileriRepository.delete(satisStratejisiOpt.get());
        } else {
            throw new RuntimeException("Satış stratejisi bulunamadı");
        }
    }
}

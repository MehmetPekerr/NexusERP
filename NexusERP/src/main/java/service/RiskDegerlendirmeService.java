package service;

import dto.RiskDegerlendirmeDTO;
import model.RiskDegerlendirme;
import repository.RiskDegerlendirmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RiskDegerlendirmeService {

    private final RiskDegerlendirmeRepository riskDegerlendirmeRepository;

    @Autowired
    public RiskDegerlendirmeService(RiskDegerlendirmeRepository riskDegerlendirmeRepository) {
        this.riskDegerlendirmeRepository = riskDegerlendirmeRepository;
    }

    // Risk değerlendirmesi oluşturma
    public void createRiskDegerlendirme(RiskDegerlendirmeDTO riskDegerlendirmeDTO) {
        RiskDegerlendirme riskDegerlendirme = new RiskDegerlendirme();
        
        // IsPlani'den alınan alanlar
        riskDegerlendirme.setPlanAdi(riskDegerlendirmeDTO.getPlanAdi());
        riskDegerlendirme.setPlanAciklama(riskDegerlendirmeDTO.getPlanAciklama());
        
        // RiskDeğerlendirme'ye özgü alanlar
        riskDegerlendirme.setRiskAd(riskDegerlendirmeDTO.getRiskAd());
        riskDegerlendirme.setRiskAciklama(riskDegerlendirmeDTO.getRiskAciklama());
        riskDegerlendirme.setDegerlendirmeTarihi(riskDegerlendirmeDTO.getDegerlendirmeTarihi());
        riskDegerlendirme.setRiskSeviyesi(riskDegerlendirmeDTO.getRiskSeviyesi());

        riskDegerlendirmeRepository.save(riskDegerlendirme);
    }

    // Tüm risk değerlendirmelerini listeleme
    public List<RiskDegerlendirmeDTO> getAllRiskDegerlendirmeler() {
        List<RiskDegerlendirme> riskDegerlendirmeler = riskDegerlendirmeRepository.findAll();
        return riskDegerlendirmeler.stream()
                .map(risk -> new RiskDegerlendirmeDTO(
                        risk.getId(),
                        risk.getPlanAdi(),
                        risk.getPlanAciklama(),
                        risk.getRiskAd(),
                        risk.getRiskAciklama(),
                        risk.getDegerlendirmeTarihi(),
                        risk.getRiskSeviyesi()))
                .collect(Collectors.toList());
    }

    // ID ile risk değerlendirmesi getirme
    public RiskDegerlendirmeDTO getRiskDegerlendirmeById(Long id) {
        Optional<RiskDegerlendirme> riskDegerlendirmeOpt = riskDegerlendirmeRepository.findById(id);
        if (riskDegerlendirmeOpt.isEmpty()) {
            throw new RuntimeException("Risk değerlendirmesi bulunamadı! ID: " + id);
        }
        RiskDegerlendirme risk = riskDegerlendirmeOpt.get();
        return new RiskDegerlendirmeDTO(
                risk.getId(),
                risk.getPlanAdi(),
                risk.getPlanAciklama(),
                risk.getRiskAd(),
                risk.getRiskAciklama(),
                risk.getDegerlendirmeTarihi(),
                risk.getRiskSeviyesi());
    }

    // Risk değerlendirmesini güncelleme
    public void updateRiskDegerlendirme(Long id, RiskDegerlendirmeDTO riskDegerlendirmeDTO) {
        Optional<RiskDegerlendirme> riskDegerlendirmeOpt = riskDegerlendirmeRepository.findById(id);
        if (riskDegerlendirmeOpt.isEmpty()) {
            throw new RuntimeException("Risk değerlendirmesi bulunamadı! ID: " + id);
        }
        RiskDegerlendirme risk = riskDegerlendirmeOpt.get();
        
        // IsPlani'den alınan alanlar
        risk.setPlanAdi(riskDegerlendirmeDTO.getPlanAdi());
        risk.setPlanAciklama(riskDegerlendirmeDTO.getPlanAciklama());

        // RiskDeğerlendirme'ye özgü alanlar
        risk.setRiskAd(riskDegerlendirmeDTO.getRiskAd());
        risk.setRiskAciklama(riskDegerlendirmeDTO.getRiskAciklama());
        risk.setDegerlendirmeTarihi(riskDegerlendirmeDTO.getDegerlendirmeTarihi());
        risk.setRiskSeviyesi(riskDegerlendirmeDTO.getRiskSeviyesi());

        riskDegerlendirmeRepository.save(risk);
    }

    // Risk değerlendirmesini silme
    public void deleteRiskDegerlendirme(Long id) {
        Optional<RiskDegerlendirme> riskDegerlendirmeOpt = riskDegerlendirmeRepository.findById(id);
        if (riskDegerlendirmeOpt.isEmpty()) {
            throw new RuntimeException("Risk değerlendirmesi bulunamadı! ID: " + id);
        }
        RiskDegerlendirme risk = riskDegerlendirmeOpt.get();
        riskDegerlendirmeRepository.delete(risk);
    }
}

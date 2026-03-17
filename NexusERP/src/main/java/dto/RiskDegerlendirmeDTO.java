package dto;

import java.time.LocalDate;

public class RiskDegerlendirmeDTO {

    private Long id;
    private String planAdi;  // IsPlani'den gelen alan
    private String planAciklama;  // IsPlani'den gelen alan
    private String riskAd;
    private String riskAciklama;
    private LocalDate degerlendirmeTarihi;
    private String riskSeviyesi;

    // Parametreli constructor
    public RiskDegerlendirmeDTO(Long id, String planAdi, String planAciklama, String riskAd, String riskAciklama, LocalDate degerlendirmeTarihi, String riskSeviyesi) {
        this.id = id;
        this.planAdi = planAdi;
        this.planAciklama = planAciklama;
        this.riskAd = riskAd;
        this.riskAciklama = riskAciklama;
        this.degerlendirmeTarihi = degerlendirmeTarihi;
        this.riskSeviyesi = riskSeviyesi;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanAdi() {
        return planAdi;
    }

    public void setPlanAdi(String planAdi) {
        this.planAdi = planAdi;
    }

    public String getPlanAciklama() {
        return planAciklama;
    }

    public void setPlanAciklama(String planAciklama) {
        this.planAciklama = planAciklama;
    }

    public String getRiskAd() {
        return riskAd;
    }

    public void setRiskAd(String riskAd) {
        this.riskAd = riskAd;
    }

    public String getRiskAciklama() {
        return riskAciklama;
    }

    public void setRiskAciklama(String riskAciklama) {
        this.riskAciklama = riskAciklama;
    }

    public LocalDate getDegerlendirmeTarihi() {
        return degerlendirmeTarihi;
    }

    public void setDegerlendirmeTarihi(LocalDate degerlendirmeTarihi) {
        this.degerlendirmeTarihi = degerlendirmeTarihi;
    }

    public String getRiskSeviyesi() {
        return riskSeviyesi;
    }

    public void setRiskSeviyesi(String riskSeviyesi) {
        this.riskSeviyesi = riskSeviyesi;
    }
}

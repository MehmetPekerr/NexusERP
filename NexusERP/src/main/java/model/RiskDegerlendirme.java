package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class RiskDegerlendirme extends IsPlani {  // IsPlani'den türemekteyiz

    @Column(name = "plan_adi", nullable = false)
    private String planAdi;

    @Column(name = "plan_aciklama")
    private String planAciklama;

    @Column(name = "risk_ad", nullable = false)
    private String riskAd;

    @Column(name = "risk_aciklama")
    private String riskAciklama;

    @Column(name = "degerlendirme_tarihi", nullable = false)
    private LocalDate degerlendirmeTarihi;

    @Column(name = "risk_seviyesi", nullable = false)
    private String riskSeviyesi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;  // 'Firma' sınıfıyla ilişki

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satis_stratejileri_id", nullable = false)
    private SatisStratejileri satisStratejileri;  // 'SatisStratejileri' sınıfıyla ilişki

    // Parametresiz constructor (JPA için gereklidir)
    public RiskDegerlendirme() {
        super();  // IsPlani sınıfının parametresiz constructor'ını çağırıyoruz
    }

    // Parametreli constructor
    public RiskDegerlendirme(String isAdi, LocalDate baslangicTarihi, LocalDate bitisTarihi, String durum,
                              String planAdi, String planAciklama, String riskAd, String riskAciklama,
                              LocalDate degerlendirmeTarihi, String riskSeviyesi, Firma firma, SatisStratejileri satisStratejileri) {
        super();  // IsPlani sınıfının parametresiz constructor'ını çağırıyoruz
        setIsAdi(isAdi);
        setBaslangicTarihi(baslangicTarihi);
        setBitisTarihi(bitisTarihi);
        setDurum(durum);
        this.planAdi = planAdi;
        this.planAciklama = planAciklama;
        this.riskAd = riskAd;
        this.riskAciklama = riskAciklama;
        this.degerlendirmeTarihi = degerlendirmeTarihi;
        this.riskSeviyesi = riskSeviyesi;
        this.firma = firma;
        this.satisStratejileri = satisStratejileri;
    }

    // Getter ve Setter metodları
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

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public SatisStratejileri getSatisStratejileri() {
        return satisStratejileri;
    }

    public void setSatisStratejileri(SatisStratejileri satisStratejileri) {
        this.satisStratejileri = satisStratejileri;
    }
}

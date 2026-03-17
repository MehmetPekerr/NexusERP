package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class IsOrtaklariPerformansi extends IsPlani {

    @Column(name = "is_ortak_adi", nullable = false)
    private String isOrtakAdi;

    @Column(name = "performans_skoru")
    private Double performansSkoru;

    @Column(name = "yil", nullable = false)
    private Integer yil;

    @Column(name = "aylik_performans")
    private Double aylikPerformans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;  // 'Firma' sınıfıyla ilişki

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satis_stratejileri_id", nullable = false)
    private SatisStratejileri satisStratejileri;  // 'SatisStratejileri' sınıfıyla ilişki

    // Parametresiz constructor (JPA için gereklidir)
    public IsOrtaklariPerformansi() {
        super();  // IsPlani sınıfının parametresiz constructor'ını çağırıyoruz
    }

    // Parametreli constructor
    public IsOrtaklariPerformansi(String isAdi, LocalDate baslangicTarihi, LocalDate bitisTarihi, String durum,
                                   String isOrtakAdi, Double performansSkoru, Integer yil, Double aylikPerformans,
                                   Firma firma, SatisStratejileri satisStratejileri) {
        super();  // IsPlani sınıfının parametresiz constructor'ını çağırıyoruz
        setIsAdi(isAdi);
        setBaslangicTarihi(baslangicTarihi);
        setBitisTarihi(bitisTarihi);
        setDurum(durum);
        this.isOrtakAdi = isOrtakAdi;
        this.performansSkoru = performansSkoru;
        this.yil = yil;
        this.aylikPerformans = aylikPerformans;
        this.firma = firma;
        this.satisStratejileri = satisStratejileri;
    }

    // Getter ve Setter metodları
    public String getIsOrtakAdi() {
        return isOrtakAdi;
    }

    public void setIsOrtakAdi(String isOrtakAdi) {
        this.isOrtakAdi = isOrtakAdi;
    }

    public Double getPerformansSkoru() {
        return performansSkoru;
    }

    public void setPerformansSkoru(Double performansSkoru) {
        this.performansSkoru = performansSkoru;
    }

    public Integer getYil() {
        return yil;
    }

    public void setYil(Integer yil) {
        this.yil = yil;
    }

    public Double getAylikPerformans() {
        return aylikPerformans;
    }

    public void setAylikPerformans(Double aylikPerformans) {
        this.aylikPerformans = aylikPerformans;
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

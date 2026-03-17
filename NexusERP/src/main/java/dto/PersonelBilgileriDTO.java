package dto;

import java.time.LocalDate;

public class PersonelBilgileriDTO {
    private Long id;
    private String ad;
    private String soyad;
    private String pozisyon;
    private Double maas;
    private LocalDate iseGirisTarihi;

    // Parametresiz kurucu
    public PersonelBilgileriDTO() {}

    // Parametreli kurucu
    public PersonelBilgileriDTO(Long id, String ad, String soyad, String pozisyon, Double maas, LocalDate iseGirisTarihi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.pozisyon = pozisyon;
        this.maas = maas;
        this.iseGirisTarihi = iseGirisTarihi;
    }

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public Double getMaas() {
        return maas;
    }

    public void setMaas(Double maas) {
        this.maas = maas;
    }

    public LocalDate getIseGirisTarihi() {
        return iseGirisTarihi;
    }

    public void setIseGirisTarihi(LocalDate iseGirisTarihi) {
        this.iseGirisTarihi = iseGirisTarihi;
    }
}

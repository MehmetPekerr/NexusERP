package dto;

import java.time.LocalDate;

public class PromosyonlarDTO {

    private Long id;
    private String ad;
    private String aciklama;
    private Double indirimOrani;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;

    // Parametreli constructor
    public PromosyonlarDTO(Long id, String ad, String aciklama, Double indirimOrani, LocalDate baslangicTarihi, LocalDate bitisTarihi) {
        this.id = id;
        this.ad = ad;
        this.aciklama = aciklama;
        this.indirimOrani = indirimOrani;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
    }

    // Getter ve Setter metodları
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

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Double getIndirimOrani() {
        return indirimOrani;
    }

    public void setIndirimOrani(Double indirimOrani) {
        this.indirimOrani = indirimOrani;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDate baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDate bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }
}

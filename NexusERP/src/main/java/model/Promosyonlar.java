package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Promosyonlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String aciklama;
    private Double indirimOrani;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;

    // ManyToOne ile SatisKanallari'ni ilişkilendiriyoruz
    @ManyToOne
    @JoinColumn(name = "satis_kanali_id", nullable = false)
    private SatisKanallari satisKanali;

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

    public SatisKanallari getSatisKanali() {
        return satisKanali;
    }

    public void setSatisKanali(SatisKanallari satisKanali) {
        this.satisKanali = satisKanali;
    }

    // Satış kanalına indirim uygulama
    public void applyDiscount() {
        if (satisKanali != null) {
            System.out.println("Satış Kanalı: " + satisKanali.getKanaliAdi() + " - Uygulanan indirim oranı: " + indirimOrani + "%");
        }
    }

    public void displayDiscount() {
        if (satisKanali != null) {
            System.out.println("Promosyon: " + ad + " - İndirim Oranı: " + indirimOrani + "% - Satış Kanalı: " + satisKanali.getKanaliAdi());
        }
    }
}

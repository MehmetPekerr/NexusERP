package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "personel_bilgileri")
public class PersonelBilgileri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "soyad", nullable = false)
    private String soyad;

    @Column(name = "pozisyon", nullable = false)
    private String pozisyon;

    @Column(name = "maas", nullable = false)
    private Double maas;

    @Column(name = "ise_giris_tarihi", nullable = false)
    private LocalDate iseGirisTarihi;

    @ManyToOne
    @JoinColumn(name = "insan_kaynaklari_id", nullable = false)
    private InsanKaynaklari insanKaynaklari;

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

    public InsanKaynaklari getInsanKaynaklari() {
        return insanKaynaklari;
    }

    public void setInsanKaynaklari(InsanKaynaklari insanKaynaklari) {
        this.insanKaynaklari = insanKaynaklari;
    }
}

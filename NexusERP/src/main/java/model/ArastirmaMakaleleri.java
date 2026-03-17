package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ArastirmaMakaleleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String makaleAdi;
    private String yazar;
    private String dergiAdi;
    private String yayinTarihi;
    private String konu;

    @ManyToOne
    private Firma firma; // Firma ile ilişki

    // Getters ve Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMakaleAdi() {
        return makaleAdi;
    }

    public void setMakaleAdi(String makaleAdi) {
        this.makaleAdi = makaleAdi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getDergiAdi() {
        return dergiAdi;
    }

    public void setDergiAdi(String dergiAdi) {
        this.dergiAdi = dergiAdi;
    }

    public String getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(String yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}

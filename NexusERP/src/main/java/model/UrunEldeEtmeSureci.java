package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class UrunEldeEtmeSureci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urunAdi;
    private String tedarikciAdi;
    private String eldeEtmeTarihi;
    private String durum;

    @ManyToOne
    @JoinColumn(name = "firma_id")
    private Firma firma;

    @ManyToMany
    @JoinTable(
        name = "urun_elde_etme_urun_maliyet",
        joinColumns = @JoinColumn(name = "urun_elde_etme_sureci_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_maliyet_analizi_id")
    )
    private Set<UrunMaliyetAnalizi> urunMaliyetAnalizleri;

    @ManyToMany
    @JoinTable(
        name = "urun_elde_etme_urunler",
        joinColumns = @JoinColumn(name = "urun_elde_etme_sureci_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_id")
    )
    private Set<Urunler> urunler;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    public String getEldeEtmeTarihi() {
        return eldeEtmeTarihi;
    }

    public void setEldeEtmeTarihi(String eldeEtmeTarihi) {
        this.eldeEtmeTarihi = eldeEtmeTarihi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Set<UrunMaliyetAnalizi> getUrunMaliyetAnalizleri() {
        return urunMaliyetAnalizleri;
    }

    public void setUrunMaliyetAnalizleri(Set<UrunMaliyetAnalizi> urunMaliyetAnalizleri) {
        this.urunMaliyetAnalizleri = urunMaliyetAnalizleri;
    }

    public Set<Urunler> getUrunler() {
        return urunler;
    }

    public void setUrunler(Set<Urunler> urunler) {
        this.urunler = urunler;
    }
}

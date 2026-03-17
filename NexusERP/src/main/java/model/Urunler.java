package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Urunler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urunAdi;
    private String urunKodu;
    private Double fiyat;
    private Integer stokMiktari;

    // Many-to-Many ilişkiler
    @ManyToMany
    @JoinTable(
        name = "urunler_urun_elde_etme_sureci",
        joinColumns = @JoinColumn(name = "urun_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_elde_etme_sureci_id")
    )
    private List<UrunEldeEtmeSureci> urunEldeEtmeSureci;

    @ManyToMany
    @JoinTable(
        name = "urunler_guncelleme_bilgileri",
        joinColumns = @JoinColumn(name = "urun_id"),
        inverseJoinColumns = @JoinColumn(name = "guncelleme_bilgileri_id")
    )
    private List<GuncellemeBilgileri> guncellemeBilgileri;

    @ManyToMany
    @JoinTable(
        name = "urunler_urun_tanitim_planlari",
        joinColumns = @JoinColumn(name = "urun_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_tanitim_planlari_id")
    )
    private List<UrunTanitimPlanlari> urunTanitimPlanlari;

    @ManyToMany
    @JoinTable(
        name = "urunler_ekipman_bakim",
        joinColumns = @JoinColumn(name = "urun_id"),
        inverseJoinColumns = @JoinColumn(name = "ekipman_bakim_id")
    )
    private List<EkipmanBakim> ekipmanBakim;

    @ManyToMany
    @JoinTable(
        name = "urunler_satis_kanallari",
        joinColumns = @JoinColumn(name = "urun_id"),
        inverseJoinColumns = @JoinColumn(name = "satis_kanallari_id")
    )
    private List<SatisKanallari> satisKanallari;

    // Getter ve Setter metodları
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

    public String getUrunKodu() {
        return urunKodu;
    }

    public void setUrunKodu(String urunKodu) {
        this.urunKodu = urunKodu;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public Integer getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(Integer stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public List<UrunEldeEtmeSureci> getUrunEldeEtmeSureci() {
        return urunEldeEtmeSureci;
    }

    public void setUrunEldeEtmeSureci(List<UrunEldeEtmeSureci> urunEldeEtmeSureci) {
        this.urunEldeEtmeSureci = urunEldeEtmeSureci;
    }

    public List<GuncellemeBilgileri> getGuncellemeBilgileri() {
        return guncellemeBilgileri;
    }

    public void setGuncellemeBilgileri(List<GuncellemeBilgileri> guncellemeBilgileri) {
        this.guncellemeBilgileri = guncellemeBilgileri;
    }

    public List<UrunTanitimPlanlari> getUrunTanitimPlanlari() {
        return urunTanitimPlanlari;
    }

    public void setUrunTanitimPlanlari(List<UrunTanitimPlanlari> urunTanitimPlanlari) {
        this.urunTanitimPlanlari = urunTanitimPlanlari;
    }

    public List<EkipmanBakim> getEkipmanBakim() {
        return ekipmanBakim;
    }

    public void setEkipmanBakim(List<EkipmanBakim> ekipmanBakim) {
        this.ekipmanBakim = ekipmanBakim;
    }

    public List<SatisKanallari> getSatisKanallari() {
        return satisKanallari;
    }

    public void setSatisKanallari(List<SatisKanallari> satisKanallari) {
        this.satisKanallari = satisKanallari;
    }
}

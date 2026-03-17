package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ekipman_bakim")
public class EkipmanBakim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ekipman_adi", nullable = false)
    private String ekipmanAdi;

    @Column(name = "bakim_tarihi", nullable = false)
    private LocalDate bakimTarihi;

    @Column(name = "bakim_yapan_personel", nullable = false)
    private String bakimYapanPersonel;

    // İlişki eklemeler
    @ManyToMany
    @JoinTable(
        name = "ekipman_bakim_urun",
        joinColumns = @JoinColumn(name = "ekipman_bakim_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_id")
    )
    private List<Urunler> urunler;

    @ManyToMany
    @JoinTable(
        name = "ekipman_bakim_urun_test_raporu",
        joinColumns = @JoinColumn(name = "ekipman_bakim_id"),
        inverseJoinColumns = @JoinColumn(name = "rapor_id")
    )
    private List<UrunTestRaporlari> urunTestRaporlari;

    @ManyToMany
    @JoinTable(
        name = "ekipman_bakim_teknik_destek",
        joinColumns = @JoinColumn(name = "ekipman_bakim_id"),
        inverseJoinColumns = @JoinColumn(name = "teknik_destek_id")
    )
    private List<TeknikDestek> teknikDestek;

    // Varsayılan ve parametreli constructorlar
    public EkipmanBakim(Long id, String ekipmanAdi, LocalDate bakimTarihi, String bakimYapanPersonel) {
        this.id = id;
        this.ekipmanAdi = ekipmanAdi;
        this.bakimTarihi = bakimTarihi;
        this.bakimYapanPersonel = bakimYapanPersonel;
    }

    public EkipmanBakim() {}

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEkipmanAdi() {
        return ekipmanAdi;
    }

    public void setEkipmanAdi(String ekipmanAdi) {
        this.ekipmanAdi = ekipmanAdi;
    }

    public LocalDate getBakimTarihi() {
        return bakimTarihi;
    }

    public void setBakimTarihi(LocalDate bakimTarihi) {
        this.bakimTarihi = bakimTarihi;
    }

    public String getBakimYapanPersonel() {
        return bakimYapanPersonel;
    }

    public void setBakimYapanPersonel(String bakimYapanPersonel) {
        this.bakimYapanPersonel = bakimYapanPersonel;
    }

    // İlişkili sınıflar için Getter ve Setter'lar
    public List<Urunler> getUrunler() {
        return urunler;
    }

    public void setUrunler(List<Urunler> urunler) {
        this.urunler = urunler;
    }

    public List<UrunTestRaporlari> getUrunTestRaporlari() {
        return urunTestRaporlari;
    }

    public void setUrunTestRaporlari(List<UrunTestRaporlari> urunTestRaporlari) {
        this.urunTestRaporlari = urunTestRaporlari;
    }

    public List<TeknikDestek> getTeknikDestek() {
        return teknikDestek;
    }

    public void setTeknikDestek(List<TeknikDestek> teknikDestek) {
        this.teknikDestek = teknikDestek;
    }
}

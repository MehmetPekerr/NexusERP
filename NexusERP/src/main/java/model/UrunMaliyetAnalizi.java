package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class UrunMaliyetAnalizi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urunAdi;
    private double uretimMaliyeti;
    private double lojistikMaliyeti;
    private double digerMaliyetler;
    private double toplamMaliyet;
    private String tarih;

    @ManyToMany
    @JoinTable(
      name = "urun_maliyet_analizi_urun_elde_etme", 
      joinColumns = @JoinColumn(name = "maliyet_analizi_id"), 
      inverseJoinColumns = @JoinColumn(name = "urun_elde_etme_id"))
    private List<UrunEldeEtmeSureci> urunEldeEtmeSureci;

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

    public double getUretimMaliyeti() {
        return uretimMaliyeti;
    }

    public void setUretimMaliyeti(double uretimMaliyeti) {
        this.uretimMaliyeti = uretimMaliyeti;
    }

    public double getLojistikMaliyeti() {
        return lojistikMaliyeti;
    }

    public void setLojistikMaliyeti(double lojistikMaliyeti) {
        this.lojistikMaliyeti = lojistikMaliyeti;
    }

    public double getDigerMaliyetler() {
        return digerMaliyetler;
    }

    public void setDigerMaliyetler(double digerMaliyetler) {
        this.digerMaliyetler = digerMaliyetler;
    }

    public double getToplamMaliyet() {
        return toplamMaliyet;
    }

    public void setToplamMaliyet(double toplamMaliyet) {
        this.toplamMaliyet = toplamMaliyet;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public List<UrunEldeEtmeSureci> getUrunEldeEtmeSureci() {
        return urunEldeEtmeSureci;
    }

    public void setUrunEldeEtmeSureci(List<UrunEldeEtmeSureci> urunEldeEtmeSureci) {
        this.urunEldeEtmeSureci = urunEldeEtmeSureci;
    }
}

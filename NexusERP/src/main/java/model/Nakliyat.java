package model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Nakliyat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String islemTipi;
    private LocalDate teslimatTarihi;
    private double miktar;
    private String teslimatAdresi;

    @ManyToOne
    @JoinColumn(name = "urun_paketleme_id")
    private UrunPaketleme urunPaketleme;

    @ManyToOne
    @JoinColumn(name = "satis_id")
    private Satis satis;

    // Parametresiz constructor
    public Nakliyat() {}

    // Parametreli constructor
    public Nakliyat(Long id, String islemTipi, LocalDate teslimatTarihi, double miktar, String teslimatAdresi, UrunPaketleme urunPaketleme, Satis satis) {
        this.id = id;
        this.islemTipi = islemTipi;
        this.teslimatTarihi = teslimatTarihi;
        this.miktar = miktar;
        this.teslimatAdresi = teslimatAdresi;
        this.urunPaketleme = urunPaketleme;
        this.satis = satis;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIslemTipi() {
        return islemTipi;
    }

    public void setIslemTipi(String islemTipi) {
        this.islemTipi = islemTipi;
    }

    public LocalDate getTeslimatTarihi() {
        return teslimatTarihi;
    }

    public void setTeslimatTarihi(LocalDate teslimatTarihi) {
        this.teslimatTarihi = teslimatTarihi;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getTeslimatAdresi() {
        return teslimatAdresi;
    }

    public void setTeslimatAdresi(String teslimatAdresi) {
        this.teslimatAdresi = teslimatAdresi;
    }

    public UrunPaketleme getUrunPaketleme() {
        return urunPaketleme;
    }

    public void setUrunPaketleme(UrunPaketleme urunPaketleme) {
        this.urunPaketleme = urunPaketleme;
    }

    public Satis getSatis() {
        return satis;
    }

    public void setSatis(Satis satis) {
        this.satis = satis;
    }
}

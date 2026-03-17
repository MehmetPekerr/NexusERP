package model;

import jakarta.persistence.*;

@Entity
public class YatirimVeFinansman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String yatirimAdi;
    private String finansmanKaynagi;
    private Double yatirimMiktari;
    private String finansmanDurumu;

    @ManyToOne
    @JoinColumn(name = "firma_id") // Firma'nın ID'si burada foreign key olarak kullanılacak
    private Firma firma;

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYatirimAdi() {
        return yatirimAdi;
    }

    public void setYatirimAdi(String yatirimAdi) {
        this.yatirimAdi = yatirimAdi;
    }

    public String getFinansmanKaynagi() {
        return finansmanKaynagi;
    }

    public void setFinansmanKaynagi(String finansmanKaynagi) {
        this.finansmanKaynagi = finansmanKaynagi;
    }

    public Double getYatirimMiktari() {
        return yatirimMiktari;
    }

    public void setYatirimMiktari(Double yatirimMiktari) {
        this.yatirimMiktari = yatirimMiktari;
    }

    public String getFinansmanDurumu() {
        return finansmanDurumu;
    }

    public void setFinansmanDurumu(String finansmanDurumu) {
        this.finansmanDurumu = finansmanDurumu;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}

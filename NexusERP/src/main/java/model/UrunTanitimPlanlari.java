package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class UrunTanitimPlanlari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tanitimTuru;
    private String hedefKitlesi;
    private String baslangicTarihi;
    private String bitisTarihi;
    private String strateji;

    @ManyToMany
    @JoinTable(
            name = "urun_tanitim_planlari_urun",
            joinColumns = @JoinColumn(name = "tanitim_plani_id"),
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

    public String getTanitimTuru() {
        return tanitimTuru;
    }

    public void setTanitimTuru(String tanitimTuru) {
        this.tanitimTuru = tanitimTuru;
    }

    public String getHedefKitlesi() {
        return hedefKitlesi;
    }

    public void setHedefKitlesi(String hedefKitlesi) {
        this.hedefKitlesi = hedefKitlesi;
    }

    public String getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(String baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getStrateji() {
        return strateji;
    }

    public void setStrateji(String strateji) {
        this.strateji = strateji;
    }

    public Set<Urunler> getUrunler() {
        return urunler;
    }

    public void setUrunler(Set<Urunler> urunler) {
        this.urunler = urunler;
    }
}

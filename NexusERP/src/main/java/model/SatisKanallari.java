package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "satis_kanallari")
public class SatisKanallari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kanali_adi", nullable = false)
    private String kanaliAdi;

    @Column(name = "aciklama", nullable = false)
    private String aciklama;

    @ManyToMany
    @JoinTable(
            name = "urun_satis_kanallari", 
            joinColumns = @JoinColumn(name = "satis_kanallari_id"), 
            inverseJoinColumns = @JoinColumn(name = "urun_id")
    )
    private List<Urunler> urunler;

    @ManyToMany
    @JoinTable(
            name = "satis_kanallari_promosyonlar", 
            joinColumns = @JoinColumn(name = "satis_kanallari_id"), 
            inverseJoinColumns = @JoinColumn(name = "promosyon_id")
    )
    private List<Promosyonlar> promosyonlar;

    @ManyToMany
    @JoinTable(
            name = "satis_kanallari_siparis", 
            joinColumns = @JoinColumn(name = "satis_kanallari_id"), 
            inverseJoinColumns = @JoinColumn(name = "siparis_id")
    )
    private List<Siparis> siparisler;

    // Constructorlar, Getter ve Setterlar

    public SatisKanallari() {}

    public SatisKanallari(Long id, String kanaliAdi, String aciklama, List<Urunler> urunler, List<Promosyonlar> promosyonlar, List<Siparis> siparisler) {
        this.id = id;
        this.kanaliAdi = kanaliAdi;
        this.aciklama = aciklama;
        this.urunler = urunler;
        this.promosyonlar = promosyonlar;
        this.siparisler = siparisler;
    }

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKanaliAdi() {
        return kanaliAdi;
    }

    public void setKanaliAdi(String kanaliAdi) {
        this.kanaliAdi = kanaliAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public List<Urunler> getUrunler() {
        return urunler;
    }

    public void setUrunler(List<Urunler> urunler) {
        this.urunler = urunler;
    }

    public List<Promosyonlar> getPromosyonlar() {
        return promosyonlar;
    }

    public void setPromosyonlar(List<Promosyonlar> promosyonlar) {
        this.promosyonlar = promosyonlar;
    }

    public List<Siparis> getSiparisler() {
        return siparisler;
    }

    public void setSiparisler(List<Siparis> siparisler) {
        this.siparisler = siparisler;
    }
}

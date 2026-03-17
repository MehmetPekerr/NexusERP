package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guncelleme_bilgileri")
public class GuncellemeBilgileri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "guncelleme_tarihi")
    private LocalDate guncellemeTarihi;

    @Column(name = "aciklama")
    private String aciklama;

    @ManyToMany
    @JoinTable(
        name = "urunler_guncelleme_bilgileri", 
        joinColumns = @JoinColumn(name = "guncelleme_bilgileri_id"), 
        inverseJoinColumns = @JoinColumn(name = "urunler_id")
    )
    private Set<Urunler> urunler = new HashSet<>();

    // Parametreli constructor
    public GuncellemeBilgileri(Long id, LocalDate guncellemeTarihi, String aciklama) {
        this.id = id;
        this.guncellemeTarihi = guncellemeTarihi;
        this.aciklama = aciklama;
    }

    // Parametresiz constructor
    public GuncellemeBilgileri() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(LocalDate guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Set<Urunler> getUrunler() {
        return urunler;
    }

    public void setUrunler(Set<Urunler> urunler) {
        this.urunler = urunler;
    }
}

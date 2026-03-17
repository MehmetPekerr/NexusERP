package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class TeknikDestek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kullanici_adi")
    private String kullaniciAdi;

    @ManyToMany
    @JoinTable(
        name = "teknik_destek_ekipman_bakim",  // İlişkiyi belirten tablo adı
        joinColumns = @JoinColumn(name = "teknik_destek_id"),  // TeknikDestek tablosunun id'sine referans
        inverseJoinColumns = @JoinColumn(name = "ekipman_bakim_id")  // EkipmanBakim tablosunun id'sine referans
    )
    private Set<EkipmanBakim> ekipmanBakimlar;  // Set, ManyToMany ilişki türü

    // Getter ve Setter'lar
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public Set<EkipmanBakim> getEkipmanBakimlar() {
        return ekipmanBakimlar;
    }

    public void setEkipmanBakimlar(Set<EkipmanBakim> ekipmanBakimlar) {
        this.ekipmanBakimlar = ekipmanBakimlar;
    }

    // id getter ve setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

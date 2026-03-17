package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "satis")
public class Satis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "musteri_adi", nullable = false)
    private String musteriAdi;

    @Column(name = "satis_tarihi", nullable = false)
    private LocalDate satisTarihi;

    @Column(name = "toplam_tutar", nullable = false)
    private Double toplamTutar;

    // Nakliyat ile Many-to-Many ilişki (Dependency)
    @ManyToMany
    @JoinTable(
        name = "satis_nakliyat",
        joinColumns = @JoinColumn(name = "satis_id"),
        inverseJoinColumns = @JoinColumn(name = "nakliyat_id")
    )
    private List<Nakliyat> nakliyatlar;

    // UrunGeriBildirimleri ile Many-to-Many ilişki (Implementation)
    @ManyToMany
    @JoinTable(
        name = "satis_urun_geri_bildirimleri",
        joinColumns = @JoinColumn(name = "satis_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_geri_bildirim_id")
    )
    private List<UrunGeriBildirimleri> urunGeriBildirimleri;

    public Satis() {}

    public Satis(String musteriAdi, LocalDate satisTarihi, Double toplamTutar) {
        this.musteriAdi = musteriAdi;
        this.satisTarihi = satisTarihi;
        this.toplamTutar = toplamTutar;
    }

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public LocalDate getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(LocalDate satisTarihi) {
        this.satisTarihi = satisTarihi;
    }

    public Double getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(Double toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public List<Nakliyat> getNakliyatlar() {
        return nakliyatlar;
    }

    public void setNakliyatlar(List<Nakliyat> nakliyatlar) {
        this.nakliyatlar = nakliyatlar;
    }

    public List<UrunGeriBildirimleri> getUrunGeriBildirimleri() {
        return urunGeriBildirimleri;
    }

    public void setUrunGeriBildirimleri(List<UrunGeriBildirimleri> urunGeriBildirimleri) {
        this.urunGeriBildirimleri = urunGeriBildirimleri;
    }
}

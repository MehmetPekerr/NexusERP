package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "siparis")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "musteri_adi", nullable = false)
    private String musteriAdi;

    @Column(name = "siparis_tarihi", nullable = false)
    private LocalDate siparisTarihi;

    @Column(name = "toplam_tutar", nullable = false)
    private Double toplamTutar;

    @ManyToMany
    @JoinTable(
        name = "siparis_satis_kanallari",
        joinColumns = @JoinColumn(name = "siparis_id"),
        inverseJoinColumns = @JoinColumn(name = "satis_kanallari_id")
    )
    private Set<SatisKanallari> satisKanallari;

    @OneToOne
    @JoinColumn(name = "fatura_id", nullable = false)
    private FaturaBilgileri faturaBilgileri;

    @ManyToMany
    @JoinTable(
        name = "siparis_urun_paketleme",
        joinColumns = @JoinColumn(name = "siparis_id"),
        inverseJoinColumns = @JoinColumn(name = "urun_paketleme_id")
    )
    private Set<UrunPaketleme> urunPaketleme;

    // Getter ve Setter metotları
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

    public LocalDate getSiparisTarihi() {
        return siparisTarihi;
    }

    public void setSiparisTarihi(LocalDate siparisTarihi) {
        this.siparisTarihi = siparisTarihi;
    }

    public Double getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(Double toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Set<SatisKanallari> getSatisKanallari() {
        return satisKanallari;
    }

    public void setSatisKanallari(Set<SatisKanallari> satisKanallari) {
        this.satisKanallari = satisKanallari;
    }

    public FaturaBilgileri getFaturaBilgileri() {
        return faturaBilgileri;
    }

    public void setFaturaBilgileri(FaturaBilgileri faturaBilgileri) {
        this.faturaBilgileri = faturaBilgileri;
    }

    public Set<UrunPaketleme> getUrunPaketleme() {
        return urunPaketleme;
    }

    public void setUrunPaketleme(Set<UrunPaketleme> urunPaketleme) {
        this.urunPaketleme = urunPaketleme;
    }
}

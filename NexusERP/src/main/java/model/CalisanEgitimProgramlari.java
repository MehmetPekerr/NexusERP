package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "calisan_egitim_programlari")
public class CalisanEgitimProgramlari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "egitim_adi", nullable = false)
    private String egitimAdi;

    @Column(name = "egitim_tarihi")
    private LocalDate egitimTarihi;

    @Column(name = "calisan_adi", nullable = false)
    private String calisanAdi;

    @ManyToOne
    @JoinColumn(name = "insan_kaynaklari_id")  // İnsan Kaynakları ile ilişki
    private InsanKaynaklari insanKaynaklari;

    // Parametreli constructor
    public CalisanEgitimProgramlari(Long id, String egitimAdi, LocalDate egitimTarihi, String calisanAdi, InsanKaynaklari insanKaynaklari) {
        this.id = id;
        this.egitimAdi = egitimAdi;
        this.egitimTarihi = egitimTarihi;
        this.calisanAdi = calisanAdi;
        this.insanKaynaklari = insanKaynaklari;
    }

    // Parametresiz constructor
    public CalisanEgitimProgramlari() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEgitimAdi() {
        return egitimAdi;
    }

    public void setEgitimAdi(String egitimAdi) {
        this.egitimAdi = egitimAdi;
    }

    public LocalDate getEgitimTarihi() {
        return egitimTarihi;
    }

    public void setEgitimTarihi(LocalDate egitimTarihi) {
        this.egitimTarihi = egitimTarihi;
    }

    public String getCalisanAdi() {
        return calisanAdi;
    }

    public void setCalisanAdi(String calisanAdi) {
        this.calisanAdi = calisanAdi;
    }

    public InsanKaynaklari getInsanKaynaklari() {
        return insanKaynaklari;
    }

    public void setInsanKaynaklari(InsanKaynaklari insanKaynaklari) {
        this.insanKaynaklari = insanKaynaklari;
    }
}

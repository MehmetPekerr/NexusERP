package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class InovasyonProjeleri extends IsPlani {

    @Column(name = "proje_adi", nullable = false)
    private String projeAdi;

    @Column(name = "proje_aciklama")
    private String projeAciklama;

    @Column(name = "proje_baslangic_tarihi")
    private LocalDate projeBaslangicTarihi;

    @Column(name = "proje_bitis_tarihi")
    private LocalDate projeBitisTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;  // 'Firma' sınıfıyla ilişki

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satis_stratejileri_id", nullable = false)
    private SatisStratejileri satisStratejileri;  // 'SatisStratejileri' sınıfıyla ilişki

    // Parametreli constructor
    public InovasyonProjeleri(Long id, String projeAdi, String projeAciklama, LocalDate projeBaslangicTarihi, LocalDate projeBitisTarihi, Firma firma, SatisStratejileri satisStratejileri) {
        super();  // IsPlani constructor'ını çağırıyoruz
        setId(id);  // 'id' alanını IsPlani üzerinden ayarlıyoruz
        this.projeAdi = projeAdi;
        this.projeAciklama = projeAciklama;
        this.projeBaslangicTarihi = projeBaslangicTarihi;
        this.projeBitisTarihi = projeBitisTarihi;
        this.firma = firma;
        this.satisStratejileri = satisStratejileri;
    }

    // Parametresiz constructor
    public InovasyonProjeleri() {}

    // Getter ve Setter metodları
    public String getProjeAdi() {
        return projeAdi;
    }

    public void setProjeAdi(String projeAdi) {
        this.projeAdi = projeAdi;
    }

    public String getProjeAciklama() {
        return projeAciklama;
    }

    public void setProjeAciklama(String projeAciklama) {
        this.projeAciklama = projeAciklama;
    }

    public LocalDate getProjeBaslangicTarihi() {
        return projeBaslangicTarihi;
    }

    public void setProjeBaslangicTarihi(LocalDate projeBaslangicTarihi) {
        this.projeBaslangicTarihi = projeBaslangicTarihi;
    }

    public LocalDate getProjeBitisTarihi() {
        return projeBitisTarihi;
    }

    public void setProjeBitisTarihi(LocalDate projeBitisTarihi) {
        this.projeBitisTarihi = projeBitisTarihi;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public SatisStratejileri getSatisStratejileri() {
        return satisStratejileri;
    }

    public void setSatisStratejileri(SatisStratejileri satisStratejileri) {
        this.satisStratejileri = satisStratejileri;
    }
}

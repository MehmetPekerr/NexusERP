package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "is_plani")
@DiscriminatorColumn(name = "is_plani_type", discriminatorType = DiscriminatorType.STRING)
public class IsPlani {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_adi", nullable = false)
    private String isAdi;

    @Column(name = "baslangic_tarihi", nullable = false)
    private LocalDate baslangicTarihi;

    @Column(name = "bitis_tarihi", nullable = false)
    private LocalDate bitisTarihi;

    @Column(name = "durum", nullable = false)
    private String durum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firma_id")
    private Firma firma;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satis_stratejileri_id")
    private SatisStratejileri satisStratejileri;

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsAdi() {
        return isAdi;
    }

    public void setIsAdi(String isAdi) {
        this.isAdi = isAdi;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDate baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDate bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
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

    // İş planını gerçekleştiren metot
    public void executePlan() {
        // Planı gerçekleştirme işlevi
    }
}

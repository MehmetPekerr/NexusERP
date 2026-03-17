package model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
//PROXY PATTERN İTHALAT VE İHRACATTA AYNI TÜRDEN NESNELERİ ŞABLONDAN HIZLICA OLUŞTURUR
@Entity
@Table(name = "ithalat_ve_ihracat")
public class IthalatVeIhracat implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Benzersiz kimlik

    @Column(name = "islem_tarihi")
    private LocalDate islemTarihi;  // İşlem tarihi

    @Column(name = "islem_tipi")
    private String islemTipi;  // İthalat veya İhracat türü

    @Column(name = "miktar")
    private BigDecimal miktar;  // İşlem miktarı

    @Column(name = "birim")
    private String birim;  // Birim (kg, ton, adet vb.)

    @Column(name = "tutar")
    private BigDecimal tutar;  // İşlem tutarı

    @ManyToOne
    @JoinColumn(name = "firma_id")  // Firma ile ilişkiyi kuran foreign key
    private Firma firma;  // Firma ile ilişki

    // Parametresiz constructor
    public IthalatVeIhracat() {}

    // Parametreli constructor
    public IthalatVeIhracat(LocalDate islemTarihi, String islemTipi, BigDecimal miktar, String birim, BigDecimal tutar, Firma firma) {
        this.islemTarihi = islemTarihi;
        this.islemTipi = islemTipi;
        this.miktar = miktar;
        this.birim = birim;
        this.tutar = tutar;
        this.firma = firma;
    }

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getIslemTarihi() {
        return islemTarihi;
    }

    public void setIslemTarihi(LocalDate islemTarihi) {
        this.islemTarihi = islemTarihi;
    }

    public String getIslemTipi() {
        return islemTipi;
    }

    public void setIslemTipi(String islemTipi) {
        this.islemTipi = islemTipi;
    }

    public BigDecimal getMiktar() {
        return miktar;
    }

    public void setMiktar(BigDecimal miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public BigDecimal getTutar() {
        return tutar;
    }

    public void setTutar(BigDecimal tutar) {
        this.tutar = tutar;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    // Prototype Pattern: clone() metodu
    @Override
    public IthalatVeIhracat clone() {
        try {
            IthalatVeIhracat clone = (IthalatVeIhracat) super.clone();
            // Eğer Firma veya diğer ilişkili sınıflar da klonlanacaksa, burada detaylı klonlama yapılabilir.
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone işlemi desteklenmiyor!", e);
        }
    }
}

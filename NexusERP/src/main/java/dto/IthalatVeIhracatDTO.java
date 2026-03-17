package dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IthalatVeIhracatDTO {

    private Long firmaId;
    private LocalDate islemTarihi;
    private String islemTipi;
    private BigDecimal miktar;
    private String birim;
    private BigDecimal tutar;

    // Getter ve Setter metotları

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
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

    // Constructor

    public IthalatVeIhracatDTO(Long firmaId, LocalDate islemTarihi, String islemTipi, BigDecimal miktar, String birim, BigDecimal tutar) {
        this.firmaId = firmaId;
        this.islemTarihi = islemTarihi;
        this.islemTipi = islemTipi;
        this.miktar = miktar;
        this.birim = birim;
        this.tutar = tutar;
    }

    // Default constructor
    public IthalatVeIhracatDTO() {
    }
}

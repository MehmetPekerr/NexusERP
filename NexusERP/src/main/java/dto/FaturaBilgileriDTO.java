package dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FaturaBilgileriDTO {

    private Long id;
    private String faturaNo;
    private LocalDate faturaTarihi;
    private BigDecimal tutar;
    private String musteriAdi;
    private Long siparisId;

    // Constructor
    public FaturaBilgileriDTO(Long id, String faturaNo, LocalDate faturaTarihi, BigDecimal tutar, String musteriAdi, Long siparisId) {
        this.id = id;
        this.faturaNo = faturaNo;
        this.faturaTarihi = faturaTarihi;
        this.tutar = tutar;
        this.musteriAdi = musteriAdi;
        this.siparisId = siparisId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

    public LocalDate getFaturaTarihi() {
        return faturaTarihi;
    }

    public void setFaturaTarihi(LocalDate faturaTarihi) {
        this.faturaTarihi = faturaTarihi;
    }

    public BigDecimal getTutar() {
        return tutar;
    }

    public void setTutar(BigDecimal tutar) {
        this.tutar = tutar;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public Long getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(Long siparisId) {
        this.siparisId = siparisId;
    }
}

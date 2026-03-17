package dto;

import java.time.LocalDate;

public class SatisDTO {

    private Long id;
    private String musteriAdi;
    private LocalDate satisTarihi;
    private Double toplamTutar;

    public SatisDTO(Long id, String musteriAdi, LocalDate satisTarihi, Double toplamTutar) {
        this.id = id;
        this.musteriAdi = musteriAdi;
        this.satisTarihi = satisTarihi;
        this.toplamTutar = toplamTutar;
    }

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
}

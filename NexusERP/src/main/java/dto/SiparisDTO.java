package dto;

import java.time.LocalDate;

public class SiparisDTO {

    private Long id;
    private String musteriAdi;
    private LocalDate siparisTarihi;
    private Double toplamTutar;

    public SiparisDTO(Long id, String musteriAdi, LocalDate siparisTarihi, Double toplamTutar) {
        this.id = id;
        this.musteriAdi = musteriAdi;
        this.siparisTarihi = siparisTarihi;
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
}

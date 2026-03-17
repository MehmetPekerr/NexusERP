package dto;

import java.time.LocalDate;

public class IsPlaniDTO {

    private Long id;
    private String isAdi;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private String durum;

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
}

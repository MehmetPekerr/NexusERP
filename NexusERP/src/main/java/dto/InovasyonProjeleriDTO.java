package dto;

import java.time.LocalDate;

public class InovasyonProjeleriDTO {

    private Long id;
    private String projeAdi;
    private String projeAciklama;
    private LocalDate projeBaslangicTarihi;
    private LocalDate projeBitisTarihi;

    // Constructor
    public InovasyonProjeleriDTO(Long id, String projeAdi, String projeAciklama, LocalDate projeBaslangicTarihi, LocalDate projeBitisTarihi) {
        this.id = id;
        this.projeAdi = projeAdi;
        this.projeAciklama = projeAciklama;
        this.projeBaslangicTarihi = projeBaslangicTarihi;
        this.projeBitisTarihi = projeBitisTarihi;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}

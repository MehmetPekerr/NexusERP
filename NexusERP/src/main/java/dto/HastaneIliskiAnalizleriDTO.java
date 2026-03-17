package dto;

import java.time.LocalDate;

public class HastaneIliskiAnalizleriDTO {

    private Long id;
    private String hastaneAdi;
    private String iliskiTuru;
    private LocalDate analizTarihi;
    private String sonuc;
    private Long firmaId; // Firma'nın ID'si

    // Parametreli constructor
    public HastaneIliskiAnalizleriDTO(Long id, String hastaneAdi, String iliskiTuru, LocalDate analizTarihi, String sonuc, Long firmaId) {
        this.id = id;
        this.hastaneAdi = hastaneAdi;
        this.iliskiTuru = iliskiTuru;
        this.analizTarihi = analizTarihi;
        this.sonuc = sonuc;
        this.firmaId = firmaId;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHastaneAdi() {
        return hastaneAdi;
    }

    public void setHastaneAdi(String hastaneAdi) {
        this.hastaneAdi = hastaneAdi;
    }

    public String getIliskiTuru() {
        return iliskiTuru;
    }

    public void setIliskiTuru(String iliskiTuru) {
        this.iliskiTuru = iliskiTuru;
    }

    public LocalDate getAnalizTarihi() {
        return analizTarihi;
    }

    public void setAnalizTarihi(LocalDate analizTarihi) {
        this.analizTarihi = analizTarihi;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }
}

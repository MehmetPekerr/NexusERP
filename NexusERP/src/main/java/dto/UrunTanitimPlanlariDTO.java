package dto;

import java.util.Set;

public class UrunTanitimPlanlariDTO {

    private Long id;
    private String tanitimTuru;
    private String hedefKitlesi;
    private String baslangicTarihi;
    private String bitisTarihi;
    private String strateji;
    private Set<UrunlerDTO> urunler;

    // Constructor, Getters and Setters
    public UrunTanitimPlanlariDTO(Long id, String tanitimTuru, String hedefKitlesi, String baslangicTarihi, String bitisTarihi, String strateji, Set<UrunlerDTO> urunler) {
        this.id = id;
        this.tanitimTuru = tanitimTuru;
        this.hedefKitlesi = hedefKitlesi;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.strateji = strateji;
        this.urunler = urunler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTanitimTuru() {
        return tanitimTuru;
    }

    public void setTanitimTuru(String tanitimTuru) {
        this.tanitimTuru = tanitimTuru;
    }

    public String getHedefKitlesi() {
        return hedefKitlesi;
    }

    public void setHedefKitlesi(String hedefKitlesi) {
        this.hedefKitlesi = hedefKitlesi;
    }

    public String getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(String baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public String getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(String bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getStrateji() {
        return strateji;
    }

    public void setStrateji(String strateji) {
        this.strateji = strateji;
    }

    public Set<UrunlerDTO> getUrunler() {
        return urunler;
    }

    public void setUrunler(Set<UrunlerDTO> urunler) {
        this.urunler = urunler;
    }
}

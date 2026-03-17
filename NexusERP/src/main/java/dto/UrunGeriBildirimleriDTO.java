package dto;

import java.util.List;

public class UrunGeriBildirimleriDTO {

    private Long id;
    private String urunAdi;
    private String geriBildirim;
    private String musteriAdi;
    private int puan;
    private String tarih;
    private List<Long> satisIdListesi; // Satış ID'lerinin listesi

    // Constructor
    public UrunGeriBildirimleriDTO(Long id, String urunAdi, String geriBildirim, String musteriAdi, int puan, String tarih, List<Long> satisIdListesi) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.geriBildirim = geriBildirim;
        this.musteriAdi = musteriAdi;
        this.puan = puan;
        this.tarih = tarih;
        this.satisIdListesi = satisIdListesi;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getGeriBildirim() {
        return geriBildirim;
    }

    public void setGeriBildirim(String geriBildirim) {
        this.geriBildirim = geriBildirim;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public List<Long> getSatisIdListesi() {
        return satisIdListesi;
    }

    public void setSatisIdListesi(List<Long> satisIdListesi) {
        this.satisIdListesi = satisIdListesi;
    }
}

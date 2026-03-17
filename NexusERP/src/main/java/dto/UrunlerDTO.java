package dto;

import java.util.List;

public class UrunlerDTO {

    private Long id;
    private String urunAdi;
    private String urunKodu;
    private Double fiyat;
    private Integer stokMiktari;
    private List<Long> urunEldeEtmeSureciIds;
    private List<Long> guncellemeBilgileriIds;
    private List<Long> urunTanitimPlanlariIds;
    private List<Long> ekipmanBakimIds;
    private List<Long> satisKanallariIds;

    public UrunlerDTO(Long id, String urunAdi, String urunKodu, Double fiyat, Integer stokMiktari) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.urunKodu = urunKodu;
        this.fiyat = fiyat;
        this.stokMiktari = stokMiktari;
        this.urunEldeEtmeSureciIds = urunEldeEtmeSureciIds;
        this.guncellemeBilgileriIds = guncellemeBilgileriIds;
        this.urunTanitimPlanlariIds = urunTanitimPlanlariIds;
        this.ekipmanBakimIds = ekipmanBakimIds;
        this.satisKanallariIds = satisKanallariIds;
    }

    // Getter ve Setter metodları
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

    public String getUrunKodu() {
        return urunKodu;
    }

    public void setUrunKodu(String urunKodu) {
        this.urunKodu = urunKodu;
    }

    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public Integer getStokMiktari() {
        return stokMiktari;
    }

    public void setStokMiktari(Integer stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    public List<Long> getUrunEldeEtmeSureciIds() {
        return urunEldeEtmeSureciIds;
    }

    public void setUrunEldeEtmeSureciIds(List<Long> urunEldeEtmeSureciIds) {
        this.urunEldeEtmeSureciIds = urunEldeEtmeSureciIds;
    }

    public List<Long> getGuncellemeBilgileriIds() {
        return guncellemeBilgileriIds;
    }

    public void setGuncellemeBilgileriIds(List<Long> guncellemeBilgileriIds) {
        this.guncellemeBilgileriIds = guncellemeBilgileriIds;
    }

    public List<Long> getUrunTanitimPlanlariIds() {
        return urunTanitimPlanlariIds;
    }

    public void setUrunTanitimPlanlariIds(List<Long> urunTanitimPlanlariIds) {
        this.urunTanitimPlanlariIds = urunTanitimPlanlariIds;
    }

    public List<Long> getEkipmanBakimIds() {
        return ekipmanBakimIds;
    }

    public void setEkipmanBakimIds(List<Long> ekipmanBakimIds) {
        this.ekipmanBakimIds = ekipmanBakimIds;
    }

    public List<Long> getSatisKanallariIds() {
        return satisKanallariIds;
    }

    public void setSatisKanallariIds(List<Long> satisKanallariIds) {
        this.satisKanallariIds = satisKanallariIds;
    }
}

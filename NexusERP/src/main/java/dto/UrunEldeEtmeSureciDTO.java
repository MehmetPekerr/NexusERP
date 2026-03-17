package dto;

import java.util.Set;

public class UrunEldeEtmeSureciDTO {

    private Long id;
    private String urunAdi;
    private String tedarikciAdi;
    private String eldeEtmeTarihi;
    private String durum;
    private Long firmaId;
    private Set<Long> urunIds;
    private Set<Long> urunMaliyetAnaliziIds;

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

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    public String getEldeEtmeTarihi() {
        return eldeEtmeTarihi;
    }

    public void setEldeEtmeTarihi(String eldeEtmeTarihi) {
        this.eldeEtmeTarihi = eldeEtmeTarihi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }

    public Set<Long> getUrunIds() {
        return urunIds;
    }

    public void setUrunIds(Set<Long> urunIds) {
        this.urunIds = urunIds;
    }

    public Set<Long> getUrunMaliyetAnaliziIds() {
        return urunMaliyetAnaliziIds;
    }

    public void setUrunMaliyetAnaliziIds(Set<Long> urunMaliyetAnaliziIds) {
        this.urunMaliyetAnaliziIds = urunMaliyetAnaliziIds;
    }
}

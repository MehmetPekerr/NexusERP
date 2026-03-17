package dto;

import java.io.Serializable;
import java.util.List;

public class DepoDTO implements Serializable {

    private Long id;
    private String ad;
    private String konum;
    private int kapasite;
    private Long firmaId;  // Firma ile ilişki
    private List<Long> tedarikciIds;  // Tedarikci ile ilişki

    // Parametreli constructor
    public DepoDTO(Long id, String ad, String konum, int kapasite, Long firmaId, List<Long> tedarikciIds) {
        this.id = id;
        this.ad = ad;
        this.konum = konum;
        this.kapasite = kapasite;
        this.firmaId = firmaId;
        this.tedarikciIds = tedarikciIds;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }

    public List<Long> getTedarikciIds() {
        return tedarikciIds;
    }

    public void setTedarikciIds(List<Long> tedarikciIds) {
        this.tedarikciIds = tedarikciIds;
    }
}

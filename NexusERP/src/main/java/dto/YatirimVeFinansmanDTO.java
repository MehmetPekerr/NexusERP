package dto;

public class YatirimVeFinansmanDTO {

    private Long id;
    private String yatirimAdi;
    private String finansmanKaynagi;
    private Double yatirimMiktari;
    private String finansmanDurumu;
    private Long firmaId;  // Firma ID'si

    public YatirimVeFinansmanDTO(Long id, String yatirimAdi, String finansmanKaynagi, Double yatirimMiktari, String finansmanDurumu, Long firmaId) {
        this.id = id;
        this.yatirimAdi = yatirimAdi;
        this.finansmanKaynagi = finansmanKaynagi;
        this.yatirimMiktari = yatirimMiktari;
        this.finansmanDurumu = finansmanDurumu;
        this.firmaId = firmaId;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYatirimAdi() {
        return yatirimAdi;
    }

    public void setYatirimAdi(String yatirimAdi) {
        this.yatirimAdi = yatirimAdi;
    }

    public String getFinansmanKaynagi() {
        return finansmanKaynagi;
    }

    public void setFinansmanKaynagi(String finansmanKaynagi) {
        this.finansmanKaynagi = finansmanKaynagi;
    }

    public Double getYatirimMiktari() {
        return yatirimMiktari;
    }

    public void setYatirimMiktari(Double yatirimMiktari) {
        this.yatirimMiktari = yatirimMiktari;
    }

    public String getFinansmanDurumu() {
        return finansmanDurumu;
    }

    public void setFinansmanDurumu(String finansmanDurumu) {
        this.finansmanDurumu = finansmanDurumu;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }
}

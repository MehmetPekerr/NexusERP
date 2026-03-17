package dto;

public class SatisStratejileriDTO {

    private Long id;
    private String stratejiAdi;
    private String aciklama;

    // Constructor
    public SatisStratejileriDTO(Long id, String stratejiAdi, String aciklama) {
        this.id = id;
        this.stratejiAdi = stratejiAdi;
        this.aciklama = aciklama;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStratejiAdi() {
        return stratejiAdi;
    }

    public void setStratejiAdi(String stratejiAdi) {
        this.stratejiAdi = stratejiAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}

package dto;

public class SatisKanallariDTO {

    private Long id;
    private String kanaliAdi;
    private String aciklama;

    public SatisKanallariDTO(Long id, String kanaliAdi, String aciklama) {
        this.id = id;
        this.kanaliAdi = kanaliAdi;
        this.aciklama = aciklama;
    }

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKanaliAdi() {
        return kanaliAdi;
    }

    public void setKanaliAdi(String kanaliAdi) {
        this.kanaliAdi = kanaliAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}

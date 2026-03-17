package dto;

public class ArastirmaMakaleleriDTO {

    private Long id;
    private String makaleAdi;
    private String yazar;
    private String dergiAdi;
    private String yayinTarihi;
    private String konu;

    private Long firmaId; // Firma ID'si ekleniyor

    public ArastirmaMakaleleriDTO() {
    }

    public ArastirmaMakaleleriDTO(Long id, String makaleAdi, String yazar, String dergiAdi, String yayinTarihi, String konu, Long firmaId) {
        this.id = id;
        this.makaleAdi = makaleAdi;
        this.yazar = yazar;
        this.dergiAdi = dergiAdi;
        this.yayinTarihi = yayinTarihi;
        this.konu = konu;
        this.firmaId = firmaId;
    }

    // Getters ve Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMakaleAdi() {
        return makaleAdi;
    }

    public void setMakaleAdi(String makaleAdi) {
        this.makaleAdi = makaleAdi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getDergiAdi() {
        return dergiAdi;
    }

    public void setDergiAdi(String dergiAdi) {
        this.dergiAdi = dergiAdi;
    }

    public String getYayinTarihi() {
        return yayinTarihi;
    }

    public void setYayinTarihi(String yayinTarihi) {
        this.yayinTarihi = yayinTarihi;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public Long getFirmaId() {
        return firmaId;
    }

    public void setFirmaId(Long firmaId) {
        this.firmaId = firmaId;
    }
}

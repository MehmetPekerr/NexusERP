package dto;

public class FirmaDTO {

    private Long id;
    private String firmaAdi;
    private String firmaAdres;
    private String firmaTelefon;

    // Parametreli constructor
    public FirmaDTO(Long id, String firmaAdi, String firmaAdres, String firmaTelefon) {
        this.id = id;
        this.firmaAdi = firmaAdi;
        this.firmaAdres = firmaAdres;
        this.firmaTelefon = firmaTelefon;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public String getFirmaAdres() {
        return firmaAdres;
    }

    public void setFirmaAdres(String firmaAdres) {
        this.firmaAdres = firmaAdres;
    }

    public String getFirmaTelefon() {
        return firmaTelefon;
    }

    public void setFirmaTelefon(String firmaTelefon) {
        this.firmaTelefon = firmaTelefon;
    }
}

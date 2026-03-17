package dto;

public class TedarikciDTO {

    private Long id;
    private String tedarikciAdi;
    private String tedarikciEmail;
    private String tedarikciTelefon;

    // Constructor
    public TedarikciDTO(Long id, String tedarikciAdi, String tedarikciEmail, String tedarikciTelefon) {
        this.id = id;
        this.tedarikciAdi = tedarikciAdi;
        this.tedarikciEmail = tedarikciEmail;
        this.tedarikciTelefon = tedarikciTelefon;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    public String getTedarikciEmail() {
        return tedarikciEmail;
    }

    public void setTedarikciEmail(String tedarikciEmail) {
        this.tedarikciEmail = tedarikciEmail;
    }

    public String getTedarikciTelefon() {
        return tedarikciTelefon;
    }

    public void setTedarikciTelefon(String tedarikciTelefon) {
        this.tedarikciTelefon = tedarikciTelefon;
    }
}

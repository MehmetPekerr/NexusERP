package dto;

public class IsOrtaklariPerformansiDTO {

    private Long id;
    private String isOrtakAdi;
    private Double performansSkoru;
    private Integer yil;
    private Double aylikPerformans;

    // Constructor
    public IsOrtaklariPerformansiDTO(Long id, String isOrtakAdi, Double performansSkoru, Integer yil, Double aylikPerformans) {
        this.id = id;
        this.isOrtakAdi = isOrtakAdi;
        this.performansSkoru = performansSkoru;
        this.yil = yil;
        this.aylikPerformans = aylikPerformans;
    }

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsOrtakAdi() {
        return isOrtakAdi;
    }

    public void setIsOrtakAdi(String isOrtakAdi) {
        this.isOrtakAdi = isOrtakAdi;
    }

    public Double getPerformansSkoru() {
        return performansSkoru;
    }

    public void setPerformansSkoru(Double performansSkoru) {
        this.performansSkoru = performansSkoru;
    }

    public Integer getYil() {
        return yil;
    }

    public void setYil(Integer yil) {
        this.yil = yil;
    }

    public Double getAylikPerformans() {
        return aylikPerformans;
    }

    public void setAylikPerformans(Double aylikPerformans) {
        this.aylikPerformans = aylikPerformans;
    }
}

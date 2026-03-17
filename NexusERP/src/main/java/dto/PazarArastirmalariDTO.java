package dto;

import java.time.LocalDate;

public class PazarArastirmalariDTO {

    private Long id;
    private String baslik;
    private String hedefPazar;
    private LocalDate raporTarihi;
    private String sonuc;

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getHedefPazar() {
        return hedefPazar;
    }

    public void setHedefPazar(String hedefPazar) {
        this.hedefPazar = hedefPazar;
    }

    public LocalDate getRaporTarihi() {
        return raporTarihi;
    }

    public void setRaporTarihi(LocalDate raporTarihi) {
        this.raporTarihi = raporTarihi;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }
}

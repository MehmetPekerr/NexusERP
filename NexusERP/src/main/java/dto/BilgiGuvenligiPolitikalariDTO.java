package dto;

import java.time.LocalDate;

public class BilgiGuvenligiPolitikalariDTO {

    private Long id;
    private String politikaAdi;
    private LocalDate guncellemeTarihi;
    private String uygulamaAlanlari;

    // Parametreli constructor
    public BilgiGuvenligiPolitikalariDTO(Long id, String politikaAdi, LocalDate guncellemeTarihi, String uygulamaAlanlari) {
        this.id = id;
        this.politikaAdi = politikaAdi;
        this.guncellemeTarihi = guncellemeTarihi;
        this.uygulamaAlanlari = uygulamaAlanlari;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolitikaAdi() {
        return politikaAdi;
    }

    public void setPolitikaAdi(String politikaAdi) {
        this.politikaAdi = politikaAdi;
    }

    public LocalDate getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(LocalDate guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

    public String getUygulamaAlanlari() {
        return uygulamaAlanlari;
    }

    public void setUygulamaAlanlari(String uygulamaAlanlari) {
        this.uygulamaAlanlari = uygulamaAlanlari;
    }
}

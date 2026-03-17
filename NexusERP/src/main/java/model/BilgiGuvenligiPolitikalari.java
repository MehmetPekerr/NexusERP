package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Table(name = "bilgi_guvenligi_politikalari")
public class BilgiGuvenligiPolitikalari extends IsPlani {

    @Column(name = "politika_adi", nullable = false)
    private String politikaAdi;

    @Column(name = "guncelleme_tarihi")
    private LocalDate guncellemeTarihi;

    @Column(name = "uygulama_alanlari")
    private String uygulamaAlanlari;

    @ManyToMany
    @JoinTable(
            name = "is_plani_bilgi_guvenligi",
            joinColumns = @JoinColumn(name = "bilgi_guvenligi_id"),
            inverseJoinColumns = @JoinColumn(name = "is_plani_id")
    )
    private List<IsPlani> isPlaniListesi;

    // Getter ve Setter metodları
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

    public List<IsPlani> getIsPlaniListesi() {
        return isPlaniListesi;
    }

    public void setIsPlaniListesi(List<IsPlani> isPlaniListesi) {
        this.isPlaniListesi = isPlaniListesi;
    }
}

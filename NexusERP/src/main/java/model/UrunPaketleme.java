package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class UrunPaketleme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urunAdi;
    private String paketlemeTipi;
    private double paketBoyutu;
    private String tarih;

    // Nakliyat ile ilişki
    @OneToMany(mappedBy = "urunPaketleme")
    private List<Nakliyat> nakliyatListesi;

    // Sipariş ile ilişki
    @OneToMany(mappedBy = "urunPaketleme")
    private List<Siparis> siparisListesi;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getPaketlemeTipi() {
        return paketlemeTipi;
    }

    public void setPaketlemeTipi(String paketlemeTipi) {
        this.paketlemeTipi = paketlemeTipi;
    }

    public double getPaketBoyutu() {
        return paketBoyutu;
    }

    public void setPaketBoyutu(double paketBoyutu) {
        this.paketBoyutu = paketBoyutu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public List<Nakliyat> getNakliyatListesi() {
        return nakliyatListesi;
    }

    public void setNakliyatListesi(List<Nakliyat> nakliyatListesi) {
        this.nakliyatListesi = nakliyatListesi;
    }

    public List<Siparis> getSiparisListesi() {
        return siparisListesi;
    }

    public void setSiparisListesi(List<Siparis> siparisListesi) {
        this.siparisListesi = siparisListesi;
    }
}

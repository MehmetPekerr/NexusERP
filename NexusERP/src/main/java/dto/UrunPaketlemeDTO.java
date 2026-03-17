package dto;

import model.Nakliyat;
import model.Siparis;

import java.util.List;

public class UrunPaketlemeDTO {

    private Long id;
    private String urunAdi;
    private String paketlemeTipi;
    private double paketBoyutu;
    private String tarih;
    private List<Siparis> siparisListesi;
    private List<Nakliyat> nakliyatListesi;

    // Constructor
    public UrunPaketlemeDTO(Long id, String urunAdi, String paketlemeTipi, double paketBoyutu, String tarih,
                            List<Siparis> siparisListesi, List<Nakliyat> nakliyatListesi) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.paketlemeTipi = paketlemeTipi;
        this.paketBoyutu = paketBoyutu;
        this.tarih = tarih;
        this.siparisListesi = siparisListesi;
        this.nakliyatListesi = nakliyatListesi;
    }

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

    public List<Siparis> getSiparisListesi() {
        return siparisListesi;
    }

    public void setSiparisListesi(List<Siparis> siparisListesi) {
        this.siparisListesi = siparisListesi;
    }

    public List<Nakliyat> getNakliyatListesi() {
        return nakliyatListesi;
    }

    public void setNakliyatListesi(List<Nakliyat> nakliyatListesi) {
        this.nakliyatListesi = nakliyatListesi;
    }
}

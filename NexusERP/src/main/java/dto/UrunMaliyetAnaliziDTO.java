package dto;

import java.util.List;

public class UrunMaliyetAnaliziDTO {

    private Long id;
    private String urunAdi;
    private double uretimMaliyeti;
    private double lojistikMaliyeti;
    private double digerMaliyetler;
    private double toplamMaliyet;
    private String tarih;
    private List<Long> urunEldeEtmeSureciIdListesi; // Yeni alan, UrunEldeEtmeSureci ile ilişki

    // Constructor
    public UrunMaliyetAnaliziDTO(Long id, String urunAdi, double uretimMaliyeti, double lojistikMaliyeti, double digerMaliyetler, double toplamMaliyet, String tarih, List<Long> urunEldeEtmeSureciIdListesi) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.uretimMaliyeti = uretimMaliyeti;
        this.lojistikMaliyeti = lojistikMaliyeti;
        this.digerMaliyetler = digerMaliyetler;
        this.toplamMaliyet = toplamMaliyet;
        this.tarih = tarih;
        this.urunEldeEtmeSureciIdListesi = urunEldeEtmeSureciIdListesi;
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

    public double getUretimMaliyeti() {
        return uretimMaliyeti;
    }

    public void setUretimMaliyeti(double uretimMaliyeti) {
        this.uretimMaliyeti = uretimMaliyeti;
    }

    public double getLojistikMaliyeti() {
        return lojistikMaliyeti;
    }

    public void setLojistikMaliyeti(double lojistikMaliyeti) {
        this.lojistikMaliyeti = lojistikMaliyeti;
    }

    public double getDigerMaliyetler() {
        return digerMaliyetler;
    }

    public void setDigerMaliyetler(double digerMaliyetler) {
        this.digerMaliyetler = digerMaliyetler;
    }

    public double getToplamMaliyet() {
        return toplamMaliyet;
    }

    public void setToplamMaliyet(double toplamMaliyet) {
        this.toplamMaliyet = toplamMaliyet;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public List<Long> getUrunEldeEtmeSureciIdListesi() {
        return urunEldeEtmeSureciIdListesi;
    }

    public void setUrunEldeEtmeSureciIdListesi(List<Long> urunEldeEtmeSureciIdListesi) {
        this.urunEldeEtmeSureciIdListesi = urunEldeEtmeSureciIdListesi;
    }
}

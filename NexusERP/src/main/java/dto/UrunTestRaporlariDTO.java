package dto;

import java.time.LocalDate;

public class UrunTestRaporlariDTO {

    private Long id;
    private String urunAdi;
    private String testSonucu;
    private LocalDate testTarihi;
    private String raporDetayi;
    private Long ekipmanBakimId;  // Ekipman Bakımı ile ilişki

    public UrunTestRaporlariDTO(Long id, String urunAdi, String testSonucu, LocalDate testTarihi, String raporDetayi, Long ekipmanBakimId) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.testSonucu = testSonucu;
        this.testTarihi = testTarihi;
        this.raporDetayi = raporDetayi;
        this.ekipmanBakimId = ekipmanBakimId;
    }

    // Getter ve Setter metodları
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

    public String getTestSonucu() {
        return testSonucu;
    }

    public void setTestSonucu(String testSonucu) {
        this.testSonucu = testSonucu;
    }

    public LocalDate getTestTarihi() {
        return testTarihi;
    }

    public void setTestTarihi(LocalDate testTarihi) {
        this.testTarihi = testTarihi;
    }

    public String getRaporDetayi() {
        return raporDetayi;
    }

    public void setRaporDetayi(String raporDetayi) {
        this.raporDetayi = raporDetayi;
    }

    public Long getEkipmanBakimId() {
        return ekipmanBakimId;
    }

    public void setEkipmanBakimId(Long ekipmanBakimId) {
        this.ekipmanBakimId = ekipmanBakimId;
    }

    // Ekipman Bakımıyla ilgili detaylı bir ilişki istiyorsanız
    // Burada ek olarak EkipmanBakimDTO kullanabilirsiniz
    // public EkipmanBakimDTO ekipmanBakim;
    // Bu şekilde DTO içinde Ekipman Bakımının tüm bilgilerini alabilirsiniz.
}

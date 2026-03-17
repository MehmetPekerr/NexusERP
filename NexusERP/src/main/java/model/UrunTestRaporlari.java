package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class UrunTestRaporlari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urunAdi;
    private String testSonucu;
    private LocalDate testTarihi;
    private String raporDetayi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ekipman_bakim_id")
    private EkipmanBakim ekipmanBakim;  // Ekipman Bakımına olan ilişki

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

    public EkipmanBakim getEkipmanBakim() {
        return ekipmanBakim;
    }

    public void setEkipmanBakim(EkipmanBakim ekipmanBakim) {
        this.ekipmanBakim = ekipmanBakim;
    }

    // Eğer veritabanında performans açısından sorun olursa, burada `@Transactional` gibi anotasyonlar eklenebilir.
    // `EkipmanBakim` nesnesine ilişkin veriye yalnızca gerektiği zaman ulaşılmasını sağlamak için `Lazy` yükleme mantığı kullanılıyor.
}

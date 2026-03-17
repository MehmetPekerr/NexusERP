package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("PazarArastirmalari")
public class PazarArastirmalari extends IsPlani {

    @Column(name = "hedef_pazar", nullable = false)
    private String hedefPazar;

    @Column(name = "rapor_tarihi", nullable = false)
    private LocalDate raporTarihi;

    @Column(name = "sonuc", nullable = false)
    private String sonuc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;  // 'Firma' sınıfıyla ilişki

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satis_stratejileri_id", nullable = false)
    private SatisStratejileri satisStratejileri;  // 'SatisStratejileri' sınıfıyla ilişki

    // Parametresiz constructor (JPA için gereklidir)
    public PazarArastirmalari() {
        super();  // IsPlani sınıfının parametresiz constructor'ını çağırıyor
    }

    // Parametreli constructor
    public PazarArastirmalari(String isAdi, LocalDate baslangicTarihi, LocalDate bitisTarihi, String durum,
                               String hedefPazar, LocalDate raporTarihi, String sonuc, Firma firma, SatisStratejileri satisStratejileri) {
        super();  // IsPlani sınıfının parametresiz constructor'ını çağırıyoruz
        setIsAdi(isAdi);
        setBaslangicTarihi(baslangicTarihi);
        setBitisTarihi(bitisTarihi);
        setDurum(durum);
        this.hedefPazar = hedefPazar;
        this.raporTarihi = raporTarihi;
        this.sonuc = sonuc;
        this.firma = firma;
        this.satisStratejileri = satisStratejileri;
    }

    // Getter ve Setter metotları
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

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public SatisStratejileri getSatisStratejileri() {
        return satisStratejileri;
    }

    public void setSatisStratejileri(SatisStratejileri satisStratejileri) {
        this.satisStratejileri = satisStratejileri;
    }
}

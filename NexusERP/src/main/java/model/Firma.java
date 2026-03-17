package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "firma")
public class Firma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "firma_adi", nullable = false)
    private String firmaAdi;

    @Column(name = "firma_adres")
    private String firmaAdres;

    @Column(name = "firma_telefon")
    private String firmaTelefon;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ArastirmaMakaleleri> arastirmaMakaleleri;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HastaneIliskiAnalizleri> hastaneIliskiAnalizleri;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<YatirimVeFinansman> yatirimVeFinansman;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IsPlani> isPlani;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<IthalatVeIhracat> ithalatVeIhracat;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UrunEldeEtmeSureci> urunEldeEtmeSureci;

    @OneToMany(mappedBy = "firma", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Depo> depo;

    @OneToOne(mappedBy = "firma", cascade = CascadeType.ALL)
    private InsanKaynaklari insanKaynaklari;

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public String getFirmaAdres() {
        return firmaAdres;
    }

    public void setFirmaAdres(String firmaAdres) {
        this.firmaAdres = firmaAdres;
    }

    public String getFirmaTelefon() {
        return firmaTelefon;
    }

    public void setFirmaTelefon(String firmaTelefon) {
        this.firmaTelefon = firmaTelefon;
    }

    public List<ArastirmaMakaleleri> getArastirmaMakaleleri() {
        return arastirmaMakaleleri;
    }

    public void setArastirmaMakaleleri(List<ArastirmaMakaleleri> arastirmaMakaleleri) {
        this.arastirmaMakaleleri = arastirmaMakaleleri;
    }

    public List<HastaneIliskiAnalizleri> getHastaneIliskiAnalizleri() {
        return hastaneIliskiAnalizleri;
    }

    public void setHastaneIliskiAnalizleri(List<HastaneIliskiAnalizleri> hastaneIliskiAnalizleri) {
        this.hastaneIliskiAnalizleri = hastaneIliskiAnalizleri;
    }

    public List<YatirimVeFinansman> getYatirimVeFinansman() {
        return yatirimVeFinansman;
    }

    public void setYatirimVeFinansman(List<YatirimVeFinansman> yatirimVeFinansman) {
        this.yatirimVeFinansman = yatirimVeFinansman;
    }

    public List<IsPlani> getIsPlani() {
        return isPlani;
    }

    public void setIsPlani(List<IsPlani> isPlani) {
        this.isPlani = isPlani;
    }

    public List<IthalatVeIhracat> getIthalatVeIhracat() {
        return ithalatVeIhracat;
    }

    public void setIthalatVeIhracat(List<IthalatVeIhracat> ithalatVeIhracat) {
        this.ithalatVeIhracat = ithalatVeIhracat;
    }

    public List<UrunEldeEtmeSureci> getUrunEldeEtmeSureci() {
        return urunEldeEtmeSureci;
    }

    public void setUrunEldeEtmeSureci(List<UrunEldeEtmeSureci> urunEldeEtmeSureci) {
        this.urunEldeEtmeSureci = urunEldeEtmeSureci;
    }

    public List<Depo> getDepo() {
        return depo;
    }

    public void setDepo(List<Depo> depo) {
        this.depo = depo;
    }

    public InsanKaynaklari getInsanKaynaklari() {
        return insanKaynaklari;
    }

    public void setInsanKaynaklari(InsanKaynaklari insanKaynaklari) {
        this.insanKaynaklari = insanKaynaklari;
    }
}

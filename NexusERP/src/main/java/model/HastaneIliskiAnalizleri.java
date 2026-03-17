package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hastane_iliski_analizleri")
public class HastaneIliskiAnalizleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hastane_adi", nullable = false)
    private String hastaneAdi;

    @Column(name = "iliski_turu", nullable = false)
    private String iliskiTuru;

    @Column(name = "analiz_tarihi", nullable = false)
    private LocalDate analizTarihi;

    @Column(name = "sonuc", nullable = false)
    private String sonuc;

    @ManyToOne
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;

    // Parametreli constructor
    public HastaneIliskiAnalizleri(Long id, String hastaneAdi, String iliskiTuru, LocalDate analizTarihi, String sonuc, Firma firma) {
        this.id = id;
        this.hastaneAdi = hastaneAdi;
        this.iliskiTuru = iliskiTuru;
        this.analizTarihi = analizTarihi;
        this.sonuc = sonuc;
        this.firma = firma;
    }

    // Parametresiz constructor
    public HastaneIliskiAnalizleri() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHastaneAdi() {
        return hastaneAdi;
    }

    public void setHastaneAdi(String hastaneAdi) {
        this.hastaneAdi = hastaneAdi;
    }

    public String getIliskiTuru() {
        return iliskiTuru;
    }

    public void setIliskiTuru(String iliskiTuru) {
        this.iliskiTuru = iliskiTuru;
    }

    public LocalDate getAnalizTarihi() {
        return analizTarihi;
    }

    public void setAnalizTarihi(LocalDate analizTarihi) {
        this.analizTarihi = analizTarihi;
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
}

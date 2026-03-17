package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class UrunGeriBildirimleri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urunAdi;
    private String geriBildirim;
    private String musteriAdi;
    private int puan;
    private String tarih;

    @ManyToMany(mappedBy = "urunGeriBildirimleri")
    private List<Satis> satislar;

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

    public String getGeriBildirim() {
        return geriBildirim;
    }

    public void setGeriBildirim(String geriBildirim) {
        this.geriBildirim = geriBildirim;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public List<Satis> getSatislar() {
        return satislar;
    }

    public void setSatislar(List<Satis> satislar) {
        this.satislar = satislar;
    }
}

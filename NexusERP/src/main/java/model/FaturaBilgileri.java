package model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fatura_bilgileri")
public class FaturaBilgileri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fatura_no", nullable = false, unique = true)
    private String faturaNo;

    @Column(name = "fatura_tarihi")
    private LocalDate faturaTarihi;

    @Column(name = "tutar")
    private BigDecimal tutar;

    @Column(name = "musteri_adi")
    private String musteriAdi;

    @OneToOne
    @JoinColumn(name = "siparis_id", referencedColumnName = "id", nullable = false)
    private Siparis siparis;

    // Parametreli constructor
    public FaturaBilgileri(Long id, String faturaNo, LocalDate faturaTarihi, BigDecimal tutar, String musteriAdi, Siparis siparis) {
        this.id = id;
        this.faturaNo = faturaNo;
        this.faturaTarihi = faturaTarihi;
        this.tutar = tutar;
        this.musteriAdi = musteriAdi;
        this.siparis = siparis;
    }

    // Parametresiz constructor
    public FaturaBilgileri() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaturaNo() {
        return faturaNo;
    }

    public void setFaturaNo(String faturaNo) {
        this.faturaNo = faturaNo;
    }

    public LocalDate getFaturaTarihi() {
        return faturaTarihi;
    }

    public void setFaturaTarihi(LocalDate faturaTarihi) {
        this.faturaTarihi = faturaTarihi;
    }

    public BigDecimal getTutar() {
        return tutar;
    }

    public void setTutar(BigDecimal tutar) {
        this.tutar = tutar;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public Siparis getSiparis() {
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }
}

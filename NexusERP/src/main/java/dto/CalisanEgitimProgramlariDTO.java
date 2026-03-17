package dto;

import java.time.LocalDate;

public class CalisanEgitimProgramlariDTO {

    private Long id;
    private String egitimAdi;
    private LocalDate egitimTarihi;
    private String calisanAdi;
    private String insanKaynaklariAdi;  // İnsan Kaynakları adı eklendi

    // Parametreli constructor
    public CalisanEgitimProgramlariDTO(Long id, String egitimAdi, LocalDate egitimTarihi, String calisanAdi, String insanKaynaklariAdi) {
        this.id = id;
        this.egitimAdi = egitimAdi;
        this.egitimTarihi = egitimTarihi;
        this.calisanAdi = calisanAdi;
        this.insanKaynaklariAdi = insanKaynaklariAdi;  // İnsan Kaynakları adı eklendi
    }

    // Parametresiz constructor
    public CalisanEgitimProgramlariDTO() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEgitimAdi() {
        return egitimAdi;
    }

    public void setEgitimAdi(String egitimAdi) {
        this.egitimAdi = egitimAdi;
    }

    public LocalDate getEgitimTarihi() {
        return egitimTarihi;
    }

    public void setEgitimTarihi(LocalDate egitimTarihi) {
        this.egitimTarihi = egitimTarihi;
    }

    public String getCalisanAdi() {
        return calisanAdi;
    }

    public void setCalisanAdi(String calisanAdi) {
        this.calisanAdi = calisanAdi;
    }

    public String getInsanKaynaklariAdi() {
        return insanKaynaklariAdi;
    }

    public void setInsanKaynaklariAdi(String insanKaynaklariAdi) {
        this.insanKaynaklariAdi = insanKaynaklariAdi;
    }
}

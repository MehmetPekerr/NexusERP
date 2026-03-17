package dto;

import java.time.LocalDate;

public class EkipmanBakimDTO {

    private Long id;
    private String ekipmanAdi;
    private LocalDate bakimTarihi;
    private String bakimYapanPersonel;

    public EkipmanBakimDTO(Long id, String ekipmanAdi, LocalDate bakimTarihi, String bakimYapanPersonel) {
        this.id = id;
        this.ekipmanAdi = ekipmanAdi;
        this.bakimTarihi = bakimTarihi;
        this.bakimYapanPersonel = bakimYapanPersonel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEkipmanAdi() {
        return ekipmanAdi;
    }

    public void setEkipmanAdi(String ekipmanAdi) {
        this.ekipmanAdi = ekipmanAdi;
    }

    public LocalDate getBakimTarihi() {
        return bakimTarihi;
    }

    public void setBakimTarihi(LocalDate bakimTarihi) {
        this.bakimTarihi = bakimTarihi;
    }

    public String getBakimYapanPersonel() {
        return bakimYapanPersonel;
    }

    public void setBakimYapanPersonel(String bakimYapanPersonel) {
        this.bakimYapanPersonel = bakimYapanPersonel;
    }
}

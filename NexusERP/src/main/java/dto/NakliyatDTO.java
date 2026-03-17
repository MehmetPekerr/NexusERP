package dto;

import java.time.LocalDate;

public class NakliyatDTO {

    private Long id;
    private String islemTipi;
    private LocalDate teslimatTarihi;
    private double miktar;
    private String teslimatAdresi;
    private Long urunPaketlemeId;  // UrunPaketleme ile ilişki
    private Long satisId;           // Satis ile ilişki

    // Parametresiz constructor
    public NakliyatDTO() {}

    // Parametreli constructor
    public NakliyatDTO(Long id, String islemTipi, LocalDate teslimatTarihi, double miktar, String teslimatAdresi, Long urunPaketlemeId, Long satisId) {
        this.id = id;
        this.islemTipi = islemTipi;
        this.teslimatTarihi = teslimatTarihi;
        this.miktar = miktar;
        this.teslimatAdresi = teslimatAdresi;
        this.urunPaketlemeId = urunPaketlemeId;
        this.satisId = satisId;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIslemTipi() {
        return islemTipi;
    }

    public void setIslemTipi(String islemTipi) {
        this.islemTipi = islemTipi;
    }

    public LocalDate getTeslimatTarihi() {
        return teslimatTarihi;
    }

    public void setTeslimatTarihi(LocalDate teslimatTarihi) {
        this.teslimatTarihi = teslimatTarihi;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getTeslimatAdresi() {
        return teslimatAdresi;
    }

    public void setTeslimatAdresi(String teslimatAdresi) {
        this.teslimatAdresi = teslimatAdresi;
    }

    public Long getUrunPaketlemeId() {
        return urunPaketlemeId;
    }

    public void setUrunPaketlemeId(Long urunPaketlemeId) {
        this.urunPaketlemeId = urunPaketlemeId;
    }

    public Long getSatisId() {
        return satisId;
    }

    public void setSatisId(Long satisId) {
        this.satisId = satisId;
    }
}

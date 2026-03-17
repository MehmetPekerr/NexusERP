package dto;

import java.time.LocalDate;
import java.util.Set;

public class GuncellemeBilgileriDTO {

    private Long id;
    private LocalDate guncellemeTarihi;
    private String aciklama;
    private Set<Long> urunlerIds; // Urunler'in ID'lerini almak için

    // Parametreli constructor
    public GuncellemeBilgileriDTO(Long id, LocalDate guncellemeTarihi, String aciklama, Set<Long> urunlerIds) {
        this.id = id;
        this.guncellemeTarihi = guncellemeTarihi;
        this.aciklama = aciklama;
        this.urunlerIds = urunlerIds;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getGuncellemeTarihi() {
        return guncellemeTarihi;
    }

    public void setGuncellemeTarihi(LocalDate guncellemeTarihi) {
        this.guncellemeTarihi = guncellemeTarihi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Set<Long> getUrunlerIds() {
        return urunlerIds;
    }

    public void setUrunlerIds(Set<Long> urunlerIds) {
        this.urunlerIds = urunlerIds;
    }
}

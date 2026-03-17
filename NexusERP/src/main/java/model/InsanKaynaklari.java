package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class InsanKaynaklari extends PersonelBilgileri {

    @OneToOne
    @JoinColumn(name = "firma_id")
    private Firma firma;

    // PersonelBilgileri ile ilişki (1-*)
    @OneToMany(mappedBy = "insanKaynaklari")
    private List<PersonelBilgileri> personelBilgileriList;

    public InsanKaynaklari() {}

    public InsanKaynaklari(Long id, String ad, String soyad, String pozisyon, Double maas, LocalDate iseGirisTarihi, Firma firma) {
        super.setId(id);
        super.setAd(ad);
        super.setSoyad(soyad);
        super.setPozisyon(pozisyon);
        super.setMaas(maas);
        super.setIseGirisTarihi(iseGirisTarihi);
        this.firma = firma;
    }

    // Getter ve Setter metodları
    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public List<PersonelBilgileri> getPersonelBilgileriList() {
        return personelBilgileriList;
    }

    public void setPersonelBilgileriList(List<PersonelBilgileri> personelBilgileriList) {
        this.personelBilgileriList = personelBilgileriList;
    }
}

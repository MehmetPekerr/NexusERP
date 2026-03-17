package model;

import jakarta.persistence.*;
import java.util.List;
//FACTORY DEPO DA NESNE OLUŞTURMA SORUMLULUĞUNU ALIP KENDİSİ YAPIYOR.
@Entity
@Table(name = "depo")
public class Depo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad", nullable = false)
    private String ad;

    @Column(name = "konum", nullable = false)
    private String konum;

    @Column(name = "kapasite", nullable = false)
    private int kapasite;

    @ManyToOne
    @JoinColumn(name = "firma_id")
    private Firma firma; // Firma ile ilişki (1 - *)

    @ManyToMany
    @JoinTable(
      name = "depo_tedarikci", 
      joinColumns = @JoinColumn(name = "depo_id"), 
      inverseJoinColumns = @JoinColumn(name = "tedarikci_id"))
    private List<Tedarikci> tedarikciler; // Tedarikci ile ilişki (* - *)

    // Parametresiz constructor (JPA için gerekli)
    public Depo() {}

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getKonum() {
        return konum;
    }

    public int getKapasite() {
        return kapasite;
    }

    public Firma getFirma() {
        return firma;
    }

    public List<Tedarikci> getTedarikciler() {
        return tedarikciler;
    }

    // Depo oluşturmak için Factory Method
    public static Depo createDepo(String ad, String konum, int kapasite, Firma firma, List<Tedarikci> tedarikciler) {
        Depo depo = new Depo();
        depo.ad = ad;
        depo.konum = konum;
        depo.kapasite = kapasite;
        depo.firma = firma;
        depo.tedarikciler = tedarikciler;
        return depo;
    }

    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

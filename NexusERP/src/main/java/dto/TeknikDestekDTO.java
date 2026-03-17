
import java.util.Set;

public class TeknikDestekDTO {
    private Long id;
    private String kullaniciAdi;
    private Set<Long> ekipmanBakimIds;

    // Parametreli constructor
    public TeknikDestekDTO(Long id, String kullaniciAdi, Set<Long> ekipmanBakimIds) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.ekipmanBakimIds = ekipmanBakimIds;
    }

    // Getter ve Setter'lar
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public Set<Long> getEkipmanBakimIds() {
        return ekipmanBakimIds;
    }

    public void setEkipmanBakimIds(Set<Long> ekipmanBakimIds) {
        this.ekipmanBakimIds = ekipmanBakimIds;
    }
}

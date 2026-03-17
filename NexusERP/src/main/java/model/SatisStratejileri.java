package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "satis_stratejileri")
public class SatisStratejileri {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "strateji_adi", nullable = false)
    private String stratejiAdi;

    @Column(name = "aciklama")
    private String aciklama;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "satis_stratejileri_is_plani", 
        joinColumns = @JoinColumn(name = "satis_stratejileri_id"), 
        inverseJoinColumns = @JoinColumn(name = "is_plani_id")
    )
    private Set<IsPlani> isPlani;

    // Getter ve Setter metotları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStratejiAdi() {
        return stratejiAdi;
    }

    public void setStratejiAdi(String stratejiAdi) {
        this.stratejiAdi = stratejiAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Set<IsPlani> getIsPlani() {
        return isPlani;
    }

    public void setIsPlani(Set<IsPlani> isPlani) {
        this.isPlani = isPlani;
    }
}

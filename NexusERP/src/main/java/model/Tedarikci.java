package model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Tedarikci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tedarikciAdi;
    private String tedarikciEmail;
    private String tedarikciTelefon;

    @ManyToMany
    @JoinTable(
        name = "depo_tedarikci", // İlişki tablosu adı
        joinColumns = @JoinColumn(name = "tedarikci_id"),
        inverseJoinColumns = @JoinColumn(name = "depo_id")
    )
    private Set<Depo> depolar;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    public String getTedarikciEmail() {
        return tedarikciEmail;
    }

    public void setTedarikciEmail(String tedarikciEmail) {
        this.tedarikciEmail = tedarikciEmail;
    }

    public String getTedarikciTelefon() {
        return tedarikciTelefon;
    }

    public void setTedarikciTelefon(String tedarikciTelefon) {
        this.tedarikciTelefon = tedarikciTelefon;
    }

    public Set<Depo> getDepolar() {
        return depolar;
    }

    public void setDepolar(Set<Depo> depolar) {
        this.depolar = depolar;
    }
}

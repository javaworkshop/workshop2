package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
public class Leverancier implements Serializable {
    
    /*
    • Bedrijfsnaam
    • Rekeninggegevens 
    • Contactpersoon
    • E-mailadres 
    • Facturen
        ◦ openstaand
        ◦ betaald
    • Leveringen
    • Producten
    • Opmerkingen
    */
    
    @Column(name = "leverancier_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String bedrijfsnaam;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id")
    Adres adres;
    @Embedded
    private Rekeninggegevens rekeninggegevens = new Rekeninggegevens();
    @OneToMany(mappedBy = "leverancier", cascade = CascadeType.ALL)
    private Set<Contactpersoon> contactPersonen = new LinkedHashSet<>();
    @Column
    private String website;
    @Column
    private String emailadres;
    @OneToMany(mappedBy = "leverancier", cascade = CascadeType.ALL)
    private List<Levering> leveringen = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="leverancier_has_product", joinColumns=@JoinColumn(name="leverancier_id"), 
            inverseJoinColumns=@JoinColumn(name="artikelnummer"))
    private List<Product> producten = new ArrayList<>();
    @Column(length = 65535)
    private String opmerkingen;
    
    public Leverancier(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Rekeninggegevens getRekeninggegevens() {
        return rekeninggegevens;
    }

    public void setRekeninggegevens(Rekeninggegevens rekeninggegevens) {
        this.rekeninggegevens = rekeninggegevens;
    }

    public Set<Contactpersoon> getContactPersonen() {
        return contactPersonen;
    }

    public void setContactPersonen(Set<Contactpersoon> contactPersonen) {
        this.contactPersonen = contactPersonen;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public List<Levering> getLeveringen() {
        return leveringen;
    }

    public void setLeveringen(List<Levering> leveringen) {
        this.leveringen = leveringen;
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    public String getOpmerkingen() {
        return opmerkingen;
    }

    public void setOpmerkingen(String opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.bedrijfsnaam);
        hash = 43 * hash + Objects.hashCode(this.adres);
        hash = 43 * hash + Objects.hashCode(this.rekeninggegevens);
        hash = 43 * hash + Objects.hashCode(this.contactPersonen);
        hash = 43 * hash + Objects.hashCode(this.website);
        hash = 43 * hash + Objects.hashCode(this.emailadres);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leverancier other = (Leverancier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.bedrijfsnaam, other.bedrijfsnaam)) {
            return false;
        }
        if (!Objects.equals(this.adres, other.adres)) {
            return false;
        }
        if (!Objects.equals(this.rekeninggegevens, other.rekeninggegevens)) {
            return false;
        }
        if (!Objects.equals(this.contactPersonen, other.contactPersonen)) {
            return false;
        }
        if (!Objects.equals(this.website, other.website)) {
            return false;
        }
        if (!Objects.equals(this.emailadres, other.emailadres)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Leverancier{" + "id=" + id + ", bedrijfsnaam=" + bedrijfsnaam + ", adres=" + adres + ", rekeninggegevens=" + rekeninggegevens + ", contactPersonen=" + contactPersonen + ", website=" + website + ", emailadres=" + emailadres + '}';
    }
    
    
}
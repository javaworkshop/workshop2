package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table
public class Product implements Serializable {
    @Column @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artikelnummer;
    @Column
    private String naam;
    @Column(length = 65535)
    private String omschrijving;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productgroep_id")
    private Productgroep productgroep;
    @Column(name = "prijs_excl_btw_per_eenheid")
    private int prijsExclBtwPerEenheid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "eenheid_id")
    private Eenheid eenheid;

    public long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Productgroep getProductgroep() {
        return productgroep;
    }

    public void setProductgroep(Productgroep productgroep) {
        this.productgroep = productgroep;
    }

    public int getPrijsExclBtwPerEenheid() {
        return prijsExclBtwPerEenheid;
    }

    public void setPrijsExclBtwPerEenheid(int prijsExclBtwPerEenheid) {
        this.prijsExclBtwPerEenheid = prijsExclBtwPerEenheid;
    }

    public Eenheid getEenheid() {
        return eenheid;
    }

    public void setEenheid(Eenheid eenheid) {
        this.eenheid = eenheid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.artikelnummer ^ (this.artikelnummer >>> 32));
        hash = 53 * hash + Objects.hashCode(this.naam);
        hash = 53 * hash + Objects.hashCode(this.omschrijving);
        hash = 53 * hash + Objects.hashCode(this.productgroep);
        hash = 53 * hash + this.prijsExclBtwPerEenheid;
        hash = 53 * hash + Objects.hashCode(this.eenheid);
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
        final Product other = (Product) obj;
        if (this.artikelnummer != other.artikelnummer) {
            return false;
        }
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.omschrijving, other.omschrijving)) {
            return false;
        }
        if (!Objects.equals(this.productgroep, other.productgroep)) {
            return false;
        }
        if (this.prijsExclBtwPerEenheid != other.prijsExclBtwPerEenheid) {
            return false;
        }
        if (!Objects.equals(this.eenheid, other.eenheid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "artikelnummer=" + artikelnummer + ", naam=" + naam + ", omschrijving=" + omschrijving + ", productgroep=" + productgroep + ", prijsExclBtwPerEenheid=" + prijsExclBtwPerEenheid + ", eenheid=" + eenheid + '}';
    }
    
}

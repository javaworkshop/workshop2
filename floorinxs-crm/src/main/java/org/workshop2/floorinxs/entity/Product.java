package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable {
    @Column @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long artikelnummer;
    @Column
    private String naam;
    @Column
    private String omschrijving;
    @ManyToOne
    @JoinColumn(name = "producttype_id")
    private Producttype producttype;
    @ManyToOne
    @JoinColumn(name = "productgroep_id")
    private Productgroep productgroep;

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

    public Producttype getProductType() {
        return producttype;
    }

    public void setProductType(Producttype productType) {
        this.producttype = productType;
    }

    public Productgroep getProductgroep() {
        return productgroep;
    }

    public void setProductgroep(Productgroep productgroep) {
        this.productgroep = productgroep;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.naam);
        hash = 83 * hash + Objects.hashCode(this.omschrijving);
        hash = 83 * hash + Objects.hashCode(this.producttype);
        hash = 83 * hash + Objects.hashCode(this.productgroep);
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
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        if (!Objects.equals(this.omschrijving, other.omschrijving)) {
            return false;
        }
        if (!Objects.equals(this.producttype, other.producttype)) {
            return false;
        }
        if (!Objects.equals(this.productgroep, other.productgroep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + artikelnummer + ", naam=" + naam + ", omschrijving=" + omschrijving + ", producttype=" + producttype + ", productgroep=" + productgroep + '}';
    }
    
}

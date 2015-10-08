package org.workshop2.floorinxs.entity;

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
public class Product {
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
    
    
}

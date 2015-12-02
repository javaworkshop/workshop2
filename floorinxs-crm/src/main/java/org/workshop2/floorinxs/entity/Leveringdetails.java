package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Leveringdetails implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "artikelnummer")
    private Product product;
    @Column
    private int hoeveelheid;
    @Column
    private int prijs;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getHoeveelheid() {
        return hoeveelheid;
    }

    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.product);
        hash = 53 * hash + this.hoeveelheid;
        hash = 53 * hash + this.prijs;
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
        final Leveringdetails other = (Leveringdetails) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (this.hoeveelheid != other.hoeveelheid) {
            return false;
        }
        if (this.prijs != other.prijs) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Leveringdetails{" + "product=" + product + ", hoeveelheid=" + hoeveelheid + ", prijs=" + prijs + '}';
    }
    
    
}

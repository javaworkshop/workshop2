package org.workshop2.floorinxs.entity;

import java.util.Objects;
import javax.persistence.Column;

public class Bestellingdetails {
    private Product product;
    @Column
    private int hoeveelheid;
    @Column
    private double prijscorrectie;

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

    public double getPrijscorrectie() {
        return prijscorrectie;
    }

    public void setPrijscorrectie(double prijscorrectie) {
        this.prijscorrectie = prijscorrectie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.product);
        hash = 41 * hash + this.hoeveelheid;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.prijscorrectie) ^ (Double.doubleToLongBits(this.prijscorrectie) >>> 32));
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
        final Bestellingdetails other = (Bestellingdetails) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (this.hoeveelheid != other.hoeveelheid) {
            return false;
        }
        if (Double.doubleToLongBits(this.prijscorrectie) != Double.doubleToLongBits(other.prijscorrectie)) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return "Bestellingdetails{" + "product=" + product + ", hoeveelheid=" + hoeveelheid + ", prijscorrectie=" + prijscorrectie + '}';
    }
    
    
}

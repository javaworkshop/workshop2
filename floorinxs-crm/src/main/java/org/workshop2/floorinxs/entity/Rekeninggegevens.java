package org.workshop2.floorinxs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class Rekeninggegevens implements Serializable {
    
    @Column
    private String rekeninghouder;
    @Column
    private String iban;
    /*
    Eventueel mogelijkheden voor creditcard en dergelijke toevoegen
    */
    
    public Rekeninggegevens(){}

    /**
     * @return the rekeninghouder
     */
    public String getRekeninghouder() {
        return rekeninghouder;
    }

    /**
     * @param Rekeninghouder the rekeninghouder to set
     */
    public void setRekeninghouder(String Rekeninghouder) {
        this.rekeninghouder = Rekeninghouder;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @param Iban the iban to set
     */
    public void setIban(String Iban) {
        this.iban = Iban;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.rekeninghouder);
        hash = 53 * hash + Objects.hashCode(this.iban);
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
        final Rekeninggegevens other = (Rekeninggegevens) obj;
        if (!Objects.equals(this.rekeninghouder, other.rekeninghouder)) {
            return false;
        }
        if (!Objects.equals(this.iban, other.iban)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rekeninggegevens{" + "Rekeninghouder=" + rekeninghouder + ", Iban=" + iban + '}';
    }
    
}
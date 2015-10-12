package org.workshop2.floorinxs.entity;

import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class Rekeninggegevens {
    
    @Column
    private String Rekeninghouder;
    @Column
    private String Iban;
    /*
    Eventueel mogelijkheden voor creditcard en dergelijke toevoegen
    */
    
    public Rekeninggegevens(){}

    /**
     * @return the Rekeninghouder
     */
    public String getRekeninghouder() {
        return Rekeninghouder;
    }

    /**
     * @param Rekeninghouder the Rekeninghouder to set
     */
    public void setRekeninghouder(String Rekeninghouder) {
        this.Rekeninghouder = Rekeninghouder;
    }

    /**
     * @return the Iban
     */
    public String getIban() {
        return Iban;
    }

    /**
     * @param Iban the Iban to set
     */
    public void setIban(String Iban) {
        this.Iban = Iban;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Rekeninghouder);
        hash = 53 * hash + Objects.hashCode(this.Iban);
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
        if (!Objects.equals(this.Rekeninghouder, other.Rekeninghouder)) {
            return false;
        }
        if (!Objects.equals(this.Iban, other.Iban)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rekeninggegevens{" + "Rekeninghouder=" + Rekeninghouder + ", Iban=" + Iban + '}';
    }
    
}
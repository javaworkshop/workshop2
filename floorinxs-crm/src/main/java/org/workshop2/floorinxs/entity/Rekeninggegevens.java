package org.workshop2.floorinxs.entity;

import javax.persistence.*;

@Embeddable
class Rekeninggegevens {
    
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
}
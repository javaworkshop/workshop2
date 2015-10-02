/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.*;

/**
 *
 * @author gerbrich2
 */
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

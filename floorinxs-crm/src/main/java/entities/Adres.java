/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author gerbrich2
 */
@Embeddable
class Adres implements Serializable{
    /*
    Adres(many to many geimplementeerd, 
    voor het eventueel bijhouden van geschiedenis van vloeren, 
    bij verhuizen bewoners, voor vloerservice nieuwe bewoners)
    • straatnaam 
    • huisnummer 
    • postcode
    • woonplaats
    */
    
    @Column
    private String straatnaam;
    @Column
    private String huisnummer;
    @Column
    private String postcode;
    @Column
    private String woonplaats;
    
    public Adres(){}

    /**
     * @return the straatnaam
     */
    public String getStraatnaam() {
        return straatnaam;
    }

    /**
     * @param straatnaam the straatnaam to set
     */
    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    /**
     * @return the huisnummer
     */
    public String getHuisnummer() {
        return huisnummer;
    }

    /**
     * @param huisnummer the huisnummer to set
     */
    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return the woonplaats
     */
    public String getWoonplaats() {
        return woonplaats;
    }

    /**
     * @param woonplaats the woonplaats to set
     */
    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
    
}

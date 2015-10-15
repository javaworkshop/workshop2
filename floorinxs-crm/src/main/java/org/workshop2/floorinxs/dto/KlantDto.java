package org.workshop2.floorinxs.dto;

import java.io.Serializable;
import org.workshop2.floorinxs.entity.Adres;
import org.workshop2.floorinxs.entity.Klant;

public class KlantDto implements Serializable {
    private Klant klant;
    private Adres adres;
    
    public KlantDto() {
        klant = new Klant();
        adres = new Adres();
    }
    
    public Klant getKlant() {
        return klant;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return klant.getId();
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        klant.setId(id);
    }
    /**
     * @return the voornaam
     */
    public String getVoornaam() {
        return klant.getVoornaam();
    }

    /**
     * @param voornaam the voornaam to set
     */
    public void setVoornaam(String voornaam) {
        klant.setVoornaam(voornaam);
    }

    /**
     * @return the achternaam
     */
    public String getAchternaam() {
        return klant.getAchternaam();
    }

    /**
     * @param achternaam the achternaam to set
     */
    public void setAchternaam(String achternaam) {
        klant.setAchternaam(achternaam);
    }
    
    /**
     * @return the emailadres
     */
    public String getEmailadres() {
        return klant.getEmailadres();
    }

    /**
     * @param emailadres the emailadres to set
     */
    public void setEmailadres(String emailadres) {
        klant.setEmailadres(emailadres);
    }
    
    /**
     * @return the opmerkingen
     */
    public String getOpmerkingen() {
        return klant.getOpmerkingen();
    }

    /**
     * @param opmerkingen the opmerkingen to set
     */
    public void setOpmerkingen(String opmerkingen) {
        klant.setOpmerkingen(opmerkingen);
    }    

    /**
     * @return the straatnaam
     */
    public String getStraatnaam() {
        return adres.getStraatnaam();
    }

    /**
     * @param straatnaam the straatnaam to set
     */
    public void setStraatnaam(String straatnaam) {
        adres.setStraatnaam(straatnaam);
    }

    /**
     * @return the huisnummer
     */
    public String getHuisnummer() {
        return adres.getHuisnummer();
    }

    /**
     * @param huisnummer the huisnummer to set
     */
    public void setHuisnummer(String huisnummer) {
        adres.setHuisnummer(huisnummer);
    }

    /**
     * @return the postcode
     */
    public String getPostcode() {
        return adres.getPostcode();
    }

    /**
     * @param postcode the postcode to set
     */
    public void setPostcode(String postcode) {
        adres.setPostcode(postcode);
    }

    /**
     * @return the woonplaats
     */
    public String getWoonplaats() {
        return adres.getWoonplaats();
    }

    /**
     * @param woonplaats the woonplaats to set
     */
    public void setWoonplaats(String woonplaats) {
        adres.setWoonplaats(woonplaats);
    }
    
    public Adres getAdres() {
        return adres;
    }
    
    /**
     * @return the Rekeninghouder
     */
    public String getRekeninghouder() {
        return klant.getRekeninggegevens().getRekeninghouder();
    }

    /**
     * @param Rekeninghouder the Rekeninghouder to set
     */
    public void setRekeninghouder(String Rekeninghouder) {
        klant.getRekeninggegevens().setRekeninghouder(Rekeninghouder);
    }

    /**
     * @return the Iban
     */
    public String getIban() {
        return klant.getRekeninggegevens().getIban();
    }

    /**
     * @param Iban the Iban to set
     */
    public void setIban(String Iban) {
        klant.getRekeninggegevens().setIban(Iban);
    }
}

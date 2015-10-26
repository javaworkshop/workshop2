package org.workshop2.floorinxs.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.workshop2.floorinxs.entity.Adres;
import org.workshop2.floorinxs.entity.Factuur;
import org.workshop2.floorinxs.entity.Offerte;
import org.workshop2.floorinxs.entity.Rekeninggegevens;

public class KlantSearchDto implements SearchDto {
    private String voornaam = null;
    private Long id = 0L;
    private String achternaam = null;
    private String emailadres = null;
    private List<Adres> adressen = new ArrayList<>();
    private Rekeninggegevens rekeninggegevens = null;
    //private List<Factuur> facturen = new ArrayList<>(); moeten deze wel in deze klasse?
    //private List<Offerte> offertes = new ArrayList<>();
    private Map<String, String> aliases = new HashMap<>();

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public Adres getAdres(int index) {
        return adressen.get(index);
    }

    public void addAdres(Adres adres) {
        adressen.add(adres);
        aliases.put("adressen", "adres");
    }
    
    public void setRekeninggegevens(String rekeninghouder, String iban) {
        rekeninggegevens = new Rekeninggegevens();
        rekeninggegevens.setRekeninghouder(rekeninghouder);
        rekeninggegevens.setIban(iban);
        aliases.put("rekeninggegevens", "rekeninggegevensAlias");
    }

    public void setRekeninggegevens(Rekeninggegevens rg) {
        rekeninggegevens = rg;
        aliases.put("rekeninggegevens", "rekeninggegevensAlias");
    }
    
    public Rekeninggegevens getRekeninggegevens() {
        return rekeninggegevens;
    }
    /*
    public Factuur getFactuur(int index) {
        return facturen.get(index);
    }

    public void addFactuur(Factuur factuur) {
        facturen.add(factuur);
        aliases.put("facturen", "factuur");
    }

    public Offerte getOfferte(int index) {
        return offertes.get(index);
    }

    public void addOfferte(Offerte offerte) {
        offertes.add(offerte);
        aliases.put("offertes", "offerte");
    }
    */
    public Map<String, String> getAliases() {
        return aliases;
    }
    
    public MultiValueMap<String, String> createSearchParamMap() {
        MultiValueMap<String, String> searchParam = new LinkedMultiValueMap<>();
        if(id > 0)
            searchParam.set("id", id + "");
        if(voornaam != null)
            searchParam.set("voornaam", voornaam);
        if(achternaam != null)
            searchParam.set("achternaam", achternaam);
        if(emailadres != null)
            searchParam.set("emailadres", emailadres);
        if(rekeninggegevens != null) {
            searchParam.set("rekeninggegevensAlias.iban", rekeninggegevens.getIban());
            searchParam.set("rekeninggegevensAlias.rekeninghouder", rekeninggegevens
                    .getRekeninghouder());
        }
        
        for(Adres adres : adressen) {
            if(adres.getStraatnaam() != null)
                searchParam.add("adres.straatnaam", adres.getStraatnaam());
            if(adres.getHuisnummer() != null)
                searchParam.add("adres.huisnummer", adres.getHuisnummer());
            if(adres.getPostcode() != null)
                searchParam.add("adres.postcode", adres.getPostcode());
            if(adres.getWoonplaats() != null)
                searchParam.add("adres.huisnummer", adres.getHuisnummer());
        }
        /*
        for(Factuur factuur : facturen) {
            // TODO: logischerwijs wil je kunnen zoeken naar facturen die nog niet betaald zijn
        }
        
        for(Offerte offerte : offertes) {
            // TODO: hoe zoeken naar offertes?
        }
        */        
        return searchParam;
    }
}

package org.workshop2.floorinxs.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.workshop2.floorinxs.entity.Adres;
//import org.workshop2.floorinxs.entity.Factuur;
//import org.workshop2.floorinxs.entity.Offerte;
import org.workshop2.floorinxs.entity.Rekeninggegevens;

public class KlantSearchDto implements SearchDto {
    private String voornaam;
    private Long id;
    private String achternaam;
    private String emailadres;
    private List<Adres> adressen;
    private Rekeninggegevens rekeninggegevens;
    //private List<Factuur> facturen = new ArrayList<>(); moeten deze wel in deze klasse?
    //private List<Offerte> offertes = new ArrayList<>();
    
    private KlantSearchDto(KlantSearchDtoBuilder builder) {
        id = builder.id;
        voornaam = builder.voornaam;
        achternaam = builder.achternaam;
        emailadres = builder.emailadres;
        adressen = builder.adressen;
        rekeninggegevens = builder.rekeninggegevens;
    }
    
    @Override
    public Map<String, String> createAliasesMap() {
        Map<String, String> aliases = new HashMap<>();
        if(adressen.size() > 0)
            aliases.put("adressen", "adres");
        if(rekeninggegevens != null)
            aliases.put("rekeninggegevens", "rekeninggegevensAlias");               
        
        return aliases;
    }
    
    @Override
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
    
   public static class KlantSearchDtoBuilder {        
        private Long id = 0L;
        private String voornaam = null;
        private String achternaam = null;
        private String emailadres = null;
        private List<Adres> adressen = new ArrayList<>();
        private Rekeninggegevens rekeninggegevens = null;

        public KlantSearchDtoBuilder id(long id) {
            this.id = id;
            return this;
        }
        
        public KlantSearchDtoBuilder voornaam(String voornaam) {
            this.voornaam = voornaam;
            return this;
        }
        
        public KlantSearchDtoBuilder achternaam(String achternaam) {
            this.achternaam = achternaam;
            return this;
        }    
        
        public KlantSearchDtoBuilder emailadres(String emailadres) {
            this.emailadres = emailadres;
            return this;
        }
        
        public KlantSearchDtoBuilder addAdres(Adres adres) {
            adressen.add(adres);
            return this;
        }
        
        public KlantSearchDtoBuilder adresStraatnaam(String straatnaam, int index) {
            if(adressen.size() <= index)
                adressen.add(new Adres());
            adressen.get(index).setStraatnaam(straatnaam);
            return this;
        }
        
        public KlantSearchDtoBuilder adresHuisnummer(String huisnummer, int index) {
            if(adressen.size() <= index)
                adressen.add(new Adres());
            adressen.get(index).setHuisnummer(huisnummer);
            return this;
        }
        
        public KlantSearchDtoBuilder adresPostcode(String postcode, int index) {
            if(adressen.size() <= index)
                adressen.add(new Adres());
            adressen.get(index).setHuisnummer(postcode);
            return this;
        }
        
        public KlantSearchDtoBuilder adresWoonplaats(String woonplaats, int index) {
            if(adressen.size() <= index)
                adressen.add(new Adres());
            adressen.get(index).setWoonplaats(woonplaats);
            return this;
        }
        
        public KlantSearchDtoBuilder rekeninggegevens(Rekeninggegevens rekeninggegevens) {
            this.rekeninggegevens = rekeninggegevens;
            return this;
        }
        
        public KlantSearchDtoBuilder rekeninggegevensRekeninghouder(String rekeninghouder) {
            if(rekeninggegevens == null)
                rekeninggegevens = new Rekeninggegevens();
            rekeninggegevens.setRekeninghouder(rekeninghouder);
            return this;
        }
        
        public KlantSearchDtoBuilder rekeninggegevensIban(String iban) {
            if(rekeninggegevens == null)
                rekeninggegevens = new Rekeninggegevens();
            rekeninggegevens.setIban(iban);
            return this;
        }
        
        public KlantSearchDto build() {
            return new KlantSearchDto(this);
        }
    }
}

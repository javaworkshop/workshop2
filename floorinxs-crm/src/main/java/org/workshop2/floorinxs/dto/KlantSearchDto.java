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
    private List<String> voornamen; 
    private List<String> achternamen;
    private List<String> emailadressen;
    private List<String> straatnamen;
    private List<String> huisnummers;
    private List<String> postcodes;
    private List<String> woonplaatsen;
    private List<String> ibans;
    private List<String> rekeninghouders;
    //private List<Factuur> facturen = new ArrayList<>(); moeten deze wel in deze klasse?
    //private List<Offerte> offertes = new ArrayList<>();
    
    private KlantSearchDto(KlantSearchDtoBuilder builder) {
        voornamen = builder.voornamen;
        achternamen = builder.achternamen;
        emailadressen = builder.emailadressen;
        straatnamen = builder.straatnamen;
        huisnummers = builder.huisnummers;
        postcodes = builder.postcodes;
        woonplaatsen = builder.woonplaatsen;
        ibans = builder.ibans;
        rekeninghouders = builder.rekeninghouders;
    }
    
    @Override
    public Map<String, String> createAliasesMap() {
        Map<String, String> aliases = new HashMap<>();
        if(straatnamen.size() > 0 
                || huisnummers.size() > 0
                || postcodes.size() > 0 
                || woonplaatsen.size() > 0)
            aliases.put("adressen", "adres");       
        
        return aliases;
    }
    
    @Override
    public Map<String, List<String>> createSearchParamMap() {
        Map<String, List<String>> searchParam = new HashMap<>();

        if(voornamen != null)
            searchParam.put("voornaam", voornamen);
        if(achternamen != null)
            searchParam.put("achternaam", achternamen);
        if(emailadressen != null)
            searchParam.put("emailadres", emailadressen);
        if(ibans != null)
            searchParam.put("iban", ibans);
        if(rekeninghouders != null)
            searchParam.put("rekeninghouder", rekeninghouders);        
        if(straatnamen != null)
            searchParam.put("adres.straatnaam", straatnamen);
        if(huisnummers != null)
            searchParam.put("adres.huisnummer", huisnummers);
        if(postcodes != null)
            searchParam.put("adres.postcode", postcodes);
        if(woonplaatsen != null)
            searchParam.put("adres.woonplaats", woonplaatsen);
        if(ibans != null)
            searchParam.put("iban", ibans);
        if(rekeninghouders != null)
            searchParam.put("rekeninghouder", rekeninghouders);
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
        private List<String> voornamen = null;
        private List<String> achternamen = null;
        private List<String> emailadressen = null;
        private List<String> straatnamen = null;
        private List<String> huisnummers = null;
        private List<String> postcodes = null;
        private List<String> woonplaatsen = null;
        private List<String> ibans = null;
        private List<String> rekeninghouders = null;
        
        public KlantSearchDtoBuilder addVoornaam(String voornaam) {
            if(voornamen == null)
                voornamen = new ArrayList<>();
            voornamen.add(voornaam);
            return this;
        }
        
        public KlantSearchDtoBuilder addAchternaam(String achternaam) {
            if(achternamen == null)
                achternamen = new ArrayList<>();
            achternamen.add(achternaam);
            return this;
        }    
        
        public KlantSearchDtoBuilder addEmailadres(String emailadres) {
            if(emailadressen == null)
                emailadressen = new ArrayList<>();
            emailadressen.add(emailadres);
            return this;
        }
        
        public KlantSearchDtoBuilder addStraatnaam(String straatnaam) {
            if(straatnamen == null)
                straatnamen = new ArrayList<>();
            straatnamen.add(straatnaam);
            return this;
        }
        
        public KlantSearchDtoBuilder addHuisnummer(String huisnummer) {
            if(huisnummers == null)
                huisnummers = new ArrayList<>();
            huisnummers.add(huisnummer);
            return this;
        }
        
        public KlantSearchDtoBuilder addPostcode(String postcode) {
            if(postcodes == null)
                postcodes = new ArrayList<>();
            postcodes.add(postcode);
            return this;
        }
        
        public KlantSearchDtoBuilder addWoonplaats(String woonplaats) {
            if(woonplaatsen == null)
                woonplaatsen = new ArrayList<>();
            woonplaatsen.add(woonplaats);
            return this;
        }
        
        public KlantSearchDtoBuilder addRekeninghouder(String rekeninghouder) {
            if(rekeninghouders == null)
                rekeninghouders = new ArrayList<>();
            rekeninghouders.add(rekeninghouder);
            return this;
        }
        
        public KlantSearchDtoBuilder addIban(String iban) {
            if(ibans == null)
                ibans = new ArrayList<>();
            ibans.add(iban);
            return this;
        }
        
        public KlantSearchDto build() {
            KlantSearchDto klantSearchDto = new KlantSearchDto(this);
            // Eventuele checks op geldigheid data kunnen hier uitgevoerd worden
            return klantSearchDto;
        }
    }
}

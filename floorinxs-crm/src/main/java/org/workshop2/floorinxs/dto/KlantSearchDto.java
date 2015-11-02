package org.workshop2.floorinxs.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(straatnamen != null 
                || huisnummers != null
                || postcodes != null 
                || woonplaatsen != null)
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
        private String splitRegex = "\\s+";
       
        private List<String> voornamen = null;
        private List<String> achternamen = null;
        private List<String> emailadressen = null;
        private List<String> straatnamen = null;
        private List<String> huisnummers = null;
        private List<String> postcodes = null;
        private List<String> woonplaatsen = null;
        private List<String> ibans = null;
        private List<String> rekeninghouders = null;
        
        public KlantSearchDtoBuilder addVoornaam(String voornaamSearchString) {
            if(voornaamSearchString != null && !voornaamSearchString.equals("")) {
                if(voornamen == null)
                    voornamen = new ArrayList<>();
                String[] voornaamParams = voornaamSearchString.split(splitRegex);
                for(String voornaam : voornaamParams) {
                    voornamen.add(voornaam);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addAchternaam(String achternaamSearchString) {
            if(achternaamSearchString != null && !achternaamSearchString.equals("")) {
                if(achternamen == null)
                    achternamen = new ArrayList<>();
                String[] achternaamParams = achternaamSearchString.split(splitRegex);
                for(String achternaam : achternaamParams) {
                    achternamen.add(achternaam);
                }
            }
            return this;
        }    
        
        public KlantSearchDtoBuilder addEmailadres(String emailadresSearchString) {
            if(emailadresSearchString != null && !emailadresSearchString.equals("")) {
                if(emailadressen == null)
                    emailadressen = new ArrayList<>();
                String[] emailadresParams = emailadresSearchString.split(splitRegex);
                for(String emailadres : emailadresParams) {
                    emailadressen.add(emailadres);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addStraatnaam(String straatnaamSearchString) {
            if(straatnaamSearchString != null && !straatnaamSearchString.equals("")) {
                if(straatnamen == null)
                    straatnamen = new ArrayList<>();
                String[] straatnaamParams = straatnaamSearchString.split(splitRegex);
                for(String straatnaam : straatnaamParams) {
                    straatnamen.add(straatnaam);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addHuisnummer(String huisnummerSearchString) {
            if(huisnummerSearchString != null && !huisnummerSearchString.equals("")) {
                if(huisnummers == null)
                    huisnummers = new ArrayList<>();
                String[] huisnummerParams = huisnummerSearchString.split(splitRegex);
                for(String huisnummer : huisnummerParams) {
                    huisnummers.add(huisnummer);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addPostcode(String postcodeSearchString) {
            if(postcodeSearchString != null && !postcodeSearchString.equals("")) {
                if(postcodes == null)
                    postcodes = new ArrayList<>();
                String[] postcodeParams = postcodeSearchString.split(splitRegex);
                for(String postcode : postcodeParams) {
                    postcodes.add(postcode);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addWoonplaats(String woonplaatsSearchString) {
            if(woonplaatsSearchString != null && !woonplaatsSearchString.equals("")) {
                if(woonplaatsen == null)
                    woonplaatsen = new ArrayList<>();
                String[] woonplaatsParams = woonplaatsSearchString.split(splitRegex);
                for(String woonplaats : woonplaatsParams) {
                    woonplaatsen.add(woonplaats);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addRekeninghouder(String rekeninghouderSearchString) {
            if(rekeninghouderSearchString != null && !rekeninghouderSearchString.equals("")) {
                if(rekeninghouders == null)
                    rekeninghouders = new ArrayList<>();
                String[] rekeninghouderParams = rekeninghouderSearchString.split(splitRegex);
                for(String rekeninghouder : rekeninghouderParams) {
                    rekeninghouders.add(rekeninghouder);
                }
            }
            return this;
        }
        
        public KlantSearchDtoBuilder addIban(String ibanSearchString) {
            if(ibanSearchString != null && !ibanSearchString.equals("")) {
                if(ibans == null)
                    ibans = new ArrayList<>();
                String[] ibanParams = ibanSearchString.split(splitRegex);
                for(String iban : ibanParams) {
                    ibans.add(iban);
                }
            }
            return this;
        }
        
        public KlantSearchDto build() {
            KlantSearchDto klantSearchDto = new KlantSearchDto(this);
            // Eventuele checks op geldigheid data kunnen hier uitgevoerd worden
            return klantSearchDto;
        }
    }
}

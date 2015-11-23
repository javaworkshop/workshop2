/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.workshop2.floorinxs.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gerbrich2
 */
public class LeverancierSearchDto implements SearchDto{
    List<String> bedrijfsnamen;
    List<String> contactPersonen;
    List<String> emailAdressen;
    
    private LeverancierSearchDto(LeverancierSearchDtoBuilder builder){
        bedrijfsnamen = builder.bedrijfsnamen;
        contactPersonen = builder.contactPersonen;
        emailAdressen = builder.emailAdressen;
    }

    @Override
    public Map<String, List<String>> createSearchParamMap() {
        Map<String, List<String>> searchParam = new HashMap<>();

        if(bedrijfsnamen != null)
            searchParam.put("bedrijfsnaam", bedrijfsnamen);
        if(contactPersonen != null)
            searchParam.put("contactPersoon", contactPersonen);
        if(emailAdressen != null)
            searchParam.put("emailAdres", emailAdressen);  
        return searchParam;
    }

    @Override
    public Map<String, String> createAliasesMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static class LeverancierSearchDtoBuilder{
        private String splitRegex = "\\s+";
                
        List<String> bedrijfsnamen;
        List<String> contactPersonen;
        List<String> emailAdressen;  
        
        public LeverancierSearchDtoBuilder addBedrijfsnaam(java.lang.String searchString){
            return add(searchString, bedrijfsnamen);
        }
        
        public LeverancierSearchDtoBuilder addContactPersoon(String searchString){
            return add(searchString, contactPersonen);
        }
                
        public LeverancierSearchDtoBuilder addEmailAdres(String searchString){
            return add(searchString, emailAdressen);
        }
        
         public LeverancierSearchDtoBuilder add(String searchString, List<String> list) {
            if(searchString != null && !searchString.equals("")) {
                if(list == null)
                    list = new ArrayList<>();
                String[] params = searchString.split(splitRegex);
                for(String param : params) {
                    list.add(param);
                }
            }
            return this;
        }
         
        public LeverancierSearchDto build() {
            LeverancierSearchDto leverancierSearchDto = new LeverancierSearchDto(this);
            // Eventuele checks op geldigheid data kunnen hier uitgevoerd worden
            return leverancierSearchDto;
        }

    }
}
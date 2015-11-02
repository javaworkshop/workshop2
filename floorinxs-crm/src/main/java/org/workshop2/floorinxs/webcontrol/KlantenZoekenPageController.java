package org.workshop2.floorinxs.webcontrol;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.workshop2.floorinxs.dto.KlantSearchDto;
import org.workshop2.floorinxs.dto.SearchDto;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.ServiceException;

@Controller
@RequestMapping("/KlantenZoekenPage")
public class KlantenZoekenPageController {
    @Autowired
    private KlantService klantService;
    private Logger logger = LoggerFactory.getLogger(KlantenZoekenPageController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findKlanten() {
        ModelAndView model = new ModelAndView("KlantenZoekenPage");
        
        return model;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView showSearchResults(@RequestParam Map<String, String> searchParam, 
            ModelMap model) {
        logger.info(searchParam.toString());
        Set<Klant> klanten; // Een set omdat Hibernate bij outer joins de duplicaten er niet uit 
                            // haalt.
        try {
            if(searchParam.get("id").equals("")) {
                SearchDto searchDto = createKlantSearchDtoBuilder(searchParam).build();                        
                klanten = new LinkedHashSet<>(klantService.find(searchDto));
            }
            else {
                klanten = new LinkedHashSet<>();
                klanten.add(klantService.findById(Long.parseLong(searchParam.get("id"))));
            }
        }
        catch(NumberFormatException ex) {
            model.addAttribute("error", "Ongeldige waarde ingevoerd bij ID.");
            return new ModelAndView("KlantenZoekenPage", model);
        }
        catch(ServiceException ex) {
            model.addAttribute("error", "Er is een fout opgetreden bij het ophalen van data uit de"
                    + " database.");
            return new ModelAndView("KlantenZoekenPage", model);
        }

        return new ModelAndView("KlantenZoekenResultaatPage", "klanten", klanten);
    }
    
    private KlantSearchDto.KlantSearchDtoBuilder createKlantSearchDtoBuilder(
            Map<String, String> searchParam) {
        KlantSearchDto.KlantSearchDtoBuilder builder = new KlantSearchDto.KlantSearchDtoBuilder();
        
        String[] params = searchParam.get("voornaam").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addVoornaam(param);
        params = searchParam.get("achternaam").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addAchternaam(param);
        params = searchParam.get("emailadres").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addEmailadres(param);
        params = searchParam.get("straatnaam").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addStraatnaam(param);
        params = searchParam.get("huisnummer").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addHuisnummer(param);
        params = searchParam.get("postcode").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addPostcode(param);
        params = searchParam.get("woonplaats").split("\\s+");        
        for(String param : params)
            if(!param.equals(""))
                builder.addWoonplaats(param);
        
        return builder;
    }
}

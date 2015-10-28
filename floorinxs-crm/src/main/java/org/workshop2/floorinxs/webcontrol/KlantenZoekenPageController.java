package org.workshop2.floorinxs.webcontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public ModelAndView showSearchResults(@RequestParam Map<String, String> searchParam, ModelMap model) {
        logger.info(searchParam.toString());
        List<Klant> klanten;
        try {
            if(searchParam.get("id").equals("")) {
                SearchDto searchDto = new KlantSearchDto.KlantSearchDtoBuilder()
                        .voornaam(searchParam.get("voornaam"))
                        .achternaam(searchParam.get("achternaam"))
                        .emailadres(searchParam.get("emailadres"))
                        .adresStraatnaam(searchParam.get("straatnaam"), 0)
                        .adresHuisnummer(searchParam.get("huisnummer"), 0)
                        .adresPostcode(searchParam.get("postcode"), 0)
                        .adresWoonplaats(searchParam.get("woonplaats"), 0)
                        .build();
                        
                klanten = klantService.find(searchDto);
            }
            else {
                klanten = new ArrayList<>();
                klanten.add(klantService.findById(Integer.parseInt(searchParam.get("id"))));
            }
        }
        catch(NumberFormatException ex) {
            model.addAttribute("error", "Ongeldige waarde ingevoerd.");
            return new ModelAndView("KlantenZoekenPage", model);
        }
        catch(ServiceException ex) {
            model.addAttribute("error", "Er is een fout opgetreden bij het ophalen van data uit de"
                    + " database.");
            return new ModelAndView("KlantenZoekenPage", model);
        }

        return new ModelAndView("KlantenZoekenResultaatPage", "klanten", klanten);
    }
}

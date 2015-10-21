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
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.KlantService;

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
    public String showSearchResults(@RequestParam Map<String, String> searchParam, ModelMap model) {
        logger.info(searchParam.toString());
        List<Klant> klanten;
        try {
            if(!searchParam.get("id").equals("")) {
                klanten = new ArrayList<>();
                klanten.add(klantService.findById(Integer.parseInt(searchParam.get("id"))));
            }
            else
                klanten = klantService.findAll();
        }
        catch(NumberFormatException ex) {
            model.addAttribute("error", "Ongeldige waarde ingevoerd.");
            return "KlantenZoekenPage";
        }
        
        return "KlantenZoekenResultaatPage";
    }
}

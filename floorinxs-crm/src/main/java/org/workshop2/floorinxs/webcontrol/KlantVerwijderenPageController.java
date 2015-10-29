package org.workshop2.floorinxs.webcontrol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.ServiceException;

@Controller
@SessionAttributes("klant")
public class KlantVerwijderenPageController {
    @Autowired
    private KlantService klantService;
    private Logger logger = LoggerFactory.getLogger(KlantVerwijderenPageController.class);
    
    @RequestMapping(value = "/KlantVerwijderenPage", method = RequestMethod.GET)
    public String start() {
        return "KlantVerwijderenPage";
    }
    
    @RequestMapping(value = "/KlantVerwijderenPage/resultaat", method = RequestMethod.GET)
    public ModelAndView browse(@RequestParam(value = "adresno") String adresno, ModelMap model) {
        model.addAttribute("adresno", Integer.parseInt(adresno));
        return new ModelAndView("KlantVerwijderenPage", model);
    }
    
    @RequestMapping(value = "/KlantVerwijderenPage/resultaat", method = RequestMethod.POST)
    public ModelAndView returnKlant(@RequestParam(value = "id") String id, 
            @RequestParam(value = "adresno") String adresno, ModelMap model) {
        logger.info("Entered id = " + id);
        System.out.println("Entered id = " + id);
        Klant klant;
        try {
            klant = klantService.findById(Long.parseLong(id));
        }
        catch(NumberFormatException ex) {
            return new ModelAndView("KlantVerwijderenPage", "error", 
                    "Ongeldige waarde ingevoerd bij ID.");
        }
        catch(ServiceException ex) {
            return new ModelAndView("KlantVerwijderenPage", "error", 
                    "Er is een fout opgetreden bij het ophalen van data uit de database.");
        }        

        model.addAttribute("adresno", Integer.parseInt(adresno));
        model.addAttribute("klant", klant);

        return new ModelAndView("KlantVerwijderenPage", model);
    }
}

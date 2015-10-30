package org.workshop2.floorinxs.webcontrol;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.workshop2.floorinxs.dto.KlantDto;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.ServiceException;

@Controller
@SessionAttributes("klantap")
public class KlantAanpassenPageController {
    @Autowired
    private KlantService klantService;
    private Logger logger = LoggerFactory.getLogger(KlantHomePageController.class);
    
    @RequestMapping(value = "/KlantAanpassenPage", method = RequestMethod.GET)
    public String showPage() {
        return "KlantAanpassenPage";
    }

    @RequestMapping(value = "/KlantAanpassenPage/resultaat", method = RequestMethod.POST)
    public ModelAndView returnKlant(@RequestParam(value = "id") String id, 
            @RequestParam(value = "adresno") String adresno, ModelMap model) {
        logger.info("Entered id = " + id);
        Klant klant;
        try {
            klant = klantService.findById(Long.parseLong(id));
        }
        catch(NumberFormatException ex) {
            logger.debug(ex.getMessage());
            return new ModelAndView("KlantAanpassenPage", "error", 
                    "Ongeldige waarde ingevoerd bij ID.");            
        }
        catch(ServiceException ex) {
            logger.debug(ex.getMessage());
            return new ModelAndView("KlantAanpassenPage", "error", 
                    "Er is een fout opgetreden bij het ophalen van data uit de database.");
        }        

        model.addAttribute("adresno", Integer.parseInt(adresno));
        KlantDto klantDto = new KlantDto(klant);
        model.addAttribute("klantap", klantDto);

        return new ModelAndView("KlantAanpassenPage", model);
    }
}
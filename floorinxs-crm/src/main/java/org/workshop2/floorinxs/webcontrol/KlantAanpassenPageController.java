package org.workshop2.floorinxs.webcontrol;

import java.util.Map;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.workshop2.floorinxs.dto.KlantDto;
import org.workshop2.floorinxs.entity.Adres;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.ServiceException;

@Controller
@SessionAttributes("klantap")
public class KlantAanpassenPageController {
    @Autowired
    private KlantService klantService;
    private Logger logger = LoggerFactory.getLogger(KlantAanpassenPageController.class);
    
    @RequestMapping(value = "/KlantAanpassenPage", method = RequestMethod.GET)
    public String showPage() {
        return "KlantAanpassenPage";
    }
    
    @RequestMapping(value = "/KlantAanpassenPage/resultaat", method = RequestMethod.GET)
    public ModelAndView browse(@RequestParam(value = "adresno") String adresno, ModelMap model) {
        model.addAttribute("adresno", Integer.parseInt(adresno));
        return new ModelAndView("KlantAanpassenPage", model);
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
    
    @RequestMapping(value = "/KlantAanpassenPage/adrestoevoegen", method = RequestMethod.POST)
    public ModelAndView addAdres(@Valid @ModelAttribute("klantap") KlantDto klantDto, 
            ModelMap model) {
        logger.info("Adres wordt toegevoegd: " + klantDto.getStraatnaam() + ", " 
                + klantDto.getHuisnummer() + " " + klantDto.getPostcode() 
                + klantDto.getWoonplaats());
        klantDto.addCurrentAdresToKlant();
        
        return new ModelAndView("KlantAanpassenPage", model);
    }
    
    @RequestMapping(value = "/KlantAanpassenPage/adresaanpassen", method = RequestMethod.POST)
    public ModelAndView updateAdressen(@Valid @ModelAttribute("klantap") KlantDto klantDto, 
            @RequestParam Map<String, String> params, ModelMap model) {
        int adresno = Integer.parseInt(params.get("adresno"));
        int counter = 0;
        for(Adres adres : klantDto.getKlant().getAdressen()) {
            if(adresno == counter) {
                logger.info("Oud adres: " + adres.getStraatnaam() + ", " + adres.getHuisnummer() 
                        + " " + adres.getPostcode() + adres.getWoonplaats());
                adres.setStraatnaam(params.get("straatnaam" + adresno));
                adres.setHuisnummer(params.get("huisnummer" + adresno));
                adres.setPostcode(params.get("postcode" + adresno));
                adres.setWoonplaats(params.get("woonplaats" + adresno));
                logger.info("Nieuw adres: " + adres.getStraatnaam() + ", " + adres.getHuisnummer() 
                        + " " + adres.getPostcode() + adres.getWoonplaats());
                break;
            }
            counter++;
        }        
        model.addAttribute("adresno", adresno);
        
        return new ModelAndView("KlantAanpassenPage", model);
    }
    
    @RequestMapping(value = "/KlantAanpassenPage/aanpassen", method = RequestMethod.POST)
    public ModelAndView updateKlant(@Valid @ModelAttribute("klantap") KlantDto klantDto, 
            ModelMap model, SessionStatus sessionStatus) {
        logger.info("Klant aanpassen: id = " + klantDto.getKlant().getId());
        try {
            klantService.update(klantDto.getKlant());
        }
        catch(ServiceException ex) {
            logger.debug(ex.getMessage());
            return new ModelAndView("KlantAanpassenPage", "error", 
                    "Er is een fout opgetreden bij het aanpassen van de klant in de database.");
        }
        
        model.addAttribute("feedback", "Aanpassingen aan klant met id = " + klantDto.getId() 
                + " zijn opgeslagen in de database.");
        sessionStatus.setComplete();
        
        return new ModelAndView("KlantAanpassenPage", model);
    }
}
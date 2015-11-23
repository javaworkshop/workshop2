package org.workshop2.floorinxs.webcontrol;

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
import org.workshop2.floorinxs.dto.LeverancierSearchDto;
import org.workshop2.floorinxs.dto.SearchDto;
import org.workshop2.floorinxs.entity.Leverancier;
import org.workshop2.floorinxs.service.LeverancierService;
import org.workshop2.floorinxs.service.ServiceException;

@Controller
@RequestMapping("/LeverancierZoeken")
public class LeverancierZoekenController {
    @Autowired
    private LeverancierService leverancierService;
    private Logger logger = LoggerFactory.getLogger(LeverancierZoekenController.class);
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findLeverancieren() {
        ModelAndView model = new ModelAndView("LeverancierZoeken");
        
        return model;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView showSearchResults(@RequestParam Map<String, String> searchParam, 
            ModelMap model) {
        logger.info(searchParam.toString());
        Set<Leverancier> leverancieren; // Een set omdat Hibernate bij joins de duplicaten er niet uit haalt.

        try {
            if(searchParam.get("id").equals("")) {
                SearchDto searchDto;
                searchDto = new LeverancierSearchDto.LeverancierSearchDtoBuilder()
                        .addBedrijfsnaam(searchParam.get("Bedrijfsnaam"))
                        .addContactPersoon(searchParam.get("ContactPersoon"))
                        .addEmailAdres(searchParam.get("EmailAdres"))
                        .build();                        
                leverancieren = new LinkedHashSet<>(leverancierService.find(searchDto));
            }
            else {
                leverancieren = new LinkedHashSet<>();
                leverancieren.add(leverancierService.findById(Long.parseLong(searchParam.get("id"))));
            }
        }
        catch(NumberFormatException ex) {
            model.addAttribute("error", "Ongeldige waarde ingevoerd bij ID.");
            return new ModelAndView("LeverancierZoeken", model);
        }
        catch(ServiceException ex) {
            model.addAttribute("error", "Er is een fout opgetreden bij het ophalen van data uit de"
                    + " database.");
            return new ModelAndView("LeverancierZoeken", model);
        }

        return new ModelAndView("LeverancierZoekenResultaatPage", "leverancieren", leverancieren);
    }
}

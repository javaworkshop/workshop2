package org.workshop2.floorinxs.webcontrol;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.workshop2.floorinxs.dto.KlantDto;
import org.workshop2.floorinxs.service.KlantService;

@Controller
@RequestMapping("/KlantToevoegenPage")
public class KlantToevoegenPageController {
    
    @Autowired
    private KlantService klantService;
    private Logger logger = LoggerFactory.getLogger(KlantHomePageController.class);
    
    //WebDataBinder
    //HttpServletRequest request,final ServletRequestDataBinder binder
    /*@InitBinder
    public void initBinder(HttpServletRequest request,final ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Klant.class, new KlantEditor());
    }*/
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createKlant() {
        ModelAndView model = new ModelAndView("KlantToevoegenPage", "klanttv", new KlantDto());
        
        return model;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addKlant(@Valid @ModelAttribute("klanttv") KlantDto klantDto, BindingResult result, 
            ModelMap model) {
        klantDto.addCurrentAdresToKlant();
        klantService.save(klantDto.getKlant());
        
        logger.info("Klant opgeslagen: " + klantDto.getKlant().toString());
        
        model.addAttribute("feedback", "Klant toegevoegd aan database!<br/>Gegenereerde id: ");
        model.addAttribute("id", klantDto.getKlant().getId());
        model.addAttribute("klant", new KlantDto());
        
        return "KlantToevoegenPage";
    }
}
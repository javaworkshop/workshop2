package org.workshop2.floorinxs.webcontrol;

import javax.validation.Valid;
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
    KlantService klantService;
    
    //WebDataBinder
    //HttpServletRequest request,final ServletRequestDataBinder binder
    /*@InitBinder
    public void initBinder(HttpServletRequest request,final ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Klant.class, new KlantEditor());
    }*/
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createKlant() {
        ModelAndView model = new ModelAndView("KlantToevoegenPage", "klant", new KlantDto());
        
        return model;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addKlant(@Valid @ModelAttribute("klant") KlantDto klant, BindingResult result, 
            ModelMap model) {
        klant.getKlant().addAdres(klant.getAdres());
        klantService.save(klant.getKlant());
        
        model.addAttribute("feedback", "Klant toegevoegd aan database!<br/>Gegenereerde id: ");
        model.addAttribute("id", klant.getKlant().getId());
        model.addAttribute("klant", new KlantDto());
        
        return "KlantToevoegenPage";
    }
}
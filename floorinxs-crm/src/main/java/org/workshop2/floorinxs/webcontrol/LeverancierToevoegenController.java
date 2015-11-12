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
import org.workshop2.floorinxs.entity.Leverancier;
import org.workshop2.floorinxs.service.LeverancierService;

@Controller
@RequestMapping("/LeverancierToevoegen")
public class LeverancierToevoegenController {
    
    @Autowired
    private LeverancierService leverancierService;
    private Logger logger = LoggerFactory.getLogger(LeverancierToevoegenController.class);
    
    //WebDataBinder
    //HttpServletRequest request,final ServletRequestDataBinder binder
    /*@InitBinder
    public void initBinder(HttpServletRequest request,final ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Klant.class, new KlantEditor());
    }*/
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createLeverancier() {
        ModelAndView model = new ModelAndView("LeverancierToevoegen", "leveranciertv", new Leverancier());
        
        return model;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String addLeverancier(@Valid @ModelAttribute("leveranciertv") Leverancier leverancier, BindingResult result, 
            ModelMap model) {
        leverancierService.save(leverancier);
        
        logger.info("Klant opgeslagen: " + leverancier.toString());
        
        model.addAttribute("feedback", "Leverancier toegevoegd aan database!<br/>Gegenereerde id: ");
        model.addAttribute("id", leverancier.getId());
        model.addAttribute("leveranciertv", new Leverancier());
        
        return "LeverancierToevoegen";
    }
}
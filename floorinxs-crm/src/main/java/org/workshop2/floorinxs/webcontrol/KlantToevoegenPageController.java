package org.workshop2.floorinxs.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.workshop2.floorinxs.service.KlantService;

@Controller
public class KlantToevoegenPageController {
    
    @Autowired
    KlantService klantService;
    
    @RequestMapping("/KlantToevoegenPage")
    public ModelAndView customerPage() {
        ModelAndView model = new ModelAndView("KlantToevoegenPage");
        
        return model;
    }
}
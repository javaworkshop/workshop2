package org.workshop2.floorinxs.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KlantToevoegenPageController {
    
    @RequestMapping("/KlantToevoegenPage")
    public ModelAndView customerPage() {
        ModelAndView model = new ModelAndView("KlantToevoegenPage");
        
        return model;
    }
}
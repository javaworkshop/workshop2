package org.workshop2.floorinxs.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LeverancierHomePageController {
    private Logger logger = LoggerFactory.getLogger(LeverancierHomePageController.class);
       
    @RequestMapping("/LeverancierHomePage")
    public ModelAndView leverancierPage() {
        ModelAndView model = new ModelAndView("LeverancierHomePage");
        
        return model;
    }
}

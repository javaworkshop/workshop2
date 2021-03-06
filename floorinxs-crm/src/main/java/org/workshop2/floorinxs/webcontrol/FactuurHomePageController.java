package org.workshop2.floorinxs.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FactuurHomePageController {
    private Logger logger = LoggerFactory.getLogger(FactuurHomePageController.class);
       
    @RequestMapping("/FactuurHomePage")
    public ModelAndView klantPage() {
        ModelAndView model = new ModelAndView("FactuurHomePage");
        
        return model;
    }
}

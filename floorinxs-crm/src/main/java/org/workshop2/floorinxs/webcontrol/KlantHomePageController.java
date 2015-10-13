package org.workshop2.floorinxs.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class KlantHomePageController {
    private Logger logger = LoggerFactory.getLogger(KlantHomePageController.class);
       
    @RequestMapping("/KlantHomePage")
    public ModelAndView klantPage() {
        ModelAndView model = new ModelAndView("KlantHomePage");
        
        return model;
    }
}

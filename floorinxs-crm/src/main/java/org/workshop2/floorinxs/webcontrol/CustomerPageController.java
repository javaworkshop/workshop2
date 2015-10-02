package org.workshop2.floorinxs.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerPageController {
    
    @RequestMapping("/CustomerPage")
    public ModelAndView customerPage() {
        ModelAndView model = new ModelAndView("CustomerPage");
        model.addObject("name", "Henk");
        
        return model;
    }
}

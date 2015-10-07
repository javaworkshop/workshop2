package org.workshop2.floorinxs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:springconfig.xml")
@ComponentScan(basePackages = {"org.workshop2.floorinxs.doa", "org.workshop2.floorinxs.service", 
        "org.workshop2.floorinxs.webcontrol"})
public class SpringConfigurator {
    /*@Bean
    some method*/
}

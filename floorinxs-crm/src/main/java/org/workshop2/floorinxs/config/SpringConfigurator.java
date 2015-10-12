package org.workshop2.floorinxs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.KlantServiceMockImpl;

@Configuration
@ImportResource("classpath:springconfig.xml")
@ComponentScan(basePackages = {"org.workshop2.floorinxs.dao", "org.workshop2.floorinxs.service", 
        "org.workshop2.floorinxs.webcontrol"})
public class SpringConfigurator {
    @Bean
    public KlantService klantService() {
        return new KlantServiceMockImpl();
    }
}

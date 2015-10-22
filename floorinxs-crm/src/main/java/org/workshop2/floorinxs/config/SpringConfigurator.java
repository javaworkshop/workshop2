package org.workshop2.floorinxs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.KlantServiceImpl;

// Configuratie gaat nu helemaal via xml, misschien later proberen dat met deze klasse te doen
@EnableWebMvc
@Configuration
@ImportResource("classpath:springconfig.xml")
@ComponentScan(basePackages = {"org.workshop2.floorinxs.dao"})
public class SpringConfigurator {
    @Bean
    public KlantService klantService() {
        return new KlantServiceImpl();
    }
    
    /*@Bean
    public KlantDao klantDao() {
        return new KlantDaoImpl();
    }*/
}

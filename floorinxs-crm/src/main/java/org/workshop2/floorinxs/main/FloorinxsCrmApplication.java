package org.workshop2.floorinxs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.workshop2.floorinxs.config.SpringConfigurator;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.KlantServiceImpl;

// Deze klasse wordt helemaal niet gebruikt door tomcat...
@SpringBootApplication
@ImportResource("classpath:springconfig.xml")
@ComponentScan(basePackages = {"org.workshop2.floorinxs.dao"})
public class FloorinxsCrmApplication {
    
    public static void main(String[] args) {
        /*SpringApplication.run(new Object[]{FloorinxsCrmApplication.class, SpringConfigurator.class},
                args);*/
        SpringApplication.run(FloorinxsCrmApplication.class, args);
    }
}
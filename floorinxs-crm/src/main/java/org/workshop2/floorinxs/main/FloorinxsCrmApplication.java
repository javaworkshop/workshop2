package org.workshop2.floorinxs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.workshop2.floorinxs.config.SpringConfigurator;

@SpringBootApplication
public class FloorinxsCrmApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{FloorinxsCrmApplication.class, SpringConfigurator.class},
                args);
    }
}
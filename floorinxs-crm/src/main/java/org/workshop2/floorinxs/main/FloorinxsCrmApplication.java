package org.workshop2.floorinxs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class FloorinxsCrmApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FloorinxsCrmApplication.class, args);
    }
}
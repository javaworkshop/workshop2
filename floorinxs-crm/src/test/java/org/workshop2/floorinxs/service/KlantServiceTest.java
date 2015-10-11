package org.workshop2.floorinxs.service;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.workshop2.floorinxs.config.TestConfigurator;
import org.workshop2.floorinxs.entity.Klant;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = TestConfigurator.class)
public class KlantServiceTest {
    @Autowired
    KlantService klantService;
    @Autowired
    List<Klant> klantSample;
    
    //@Test
    public void testCreate() {
        klantService.save(klantSample.get(0));
        klantService.save(klantSample.get(1));
        Klant k1 = klantService.findById(1);
        Klant k2 = klantService.findById(2);
        // Even tijdelijk tot equals methoden geimplementeerd zijn
        System.out.println("klant1: " + k1.getId() + " " + k1.getVoornaam());
        System.out.println("klant2: " + k2.getId() + " " + k2.getVoornaam());
    }
        
}

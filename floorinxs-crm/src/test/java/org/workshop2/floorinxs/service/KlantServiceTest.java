package org.workshop2.floorinxs.service;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.workshop2.floorinxs.config.TestConfigurator;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.webcontrol.KlantHomePageController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfigurator.class)
public class KlantServiceTest {
    @Autowired
    private KlantService klantService;
    @Autowired
    private List<Klant> klantSample;
    private Logger logger = LoggerFactory.getLogger(KlantServiceTest.class);
    
    @Before
    public void setUp() {
        klantService.setEagerFetch(true);
    }
    
    @Test
    public void testCreate() {
        klantService.save(klantSample.get(0));
        klantService.save(klantSample.get(1));
        Klant k1 = klantService.findById(1L);
        Klant k2 = klantService.findById(3L);
        
        logger.info(k1.toString());
        logger.info(klantSample.get(0).toString());
        assertEquals(k1, klantSample.get(0));
        
        logger.info(k2.toString());
        logger.info(klantSample.get(1).toString());
        assertEquals(k2, klantSample.get(1));
    }        
}

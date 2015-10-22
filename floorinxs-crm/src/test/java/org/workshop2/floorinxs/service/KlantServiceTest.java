package org.workshop2.floorinxs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.workshop2.floorinxs.entity.Adres;
import org.workshop2.floorinxs.entity.Klant;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = TestConfigurator.class)
public class KlantServiceTest {
    @Autowired
    private KlantService klantService;
    @Autowired
    private List<Klant> klantSample;
    private Logger logger = LoggerFactory.getLogger(KlantServiceTest.class);
    
    //@Before
    public void setUp() {
        klantService.setEagerFetch(true);
        klantService.save(klantSample.get(0));
        klantService.save(klantSample.get(1));
    }
    
    //@Test
    public void testCreate() {        
        Klant k1 = klantService.findById(1L);
        Klant k2 = klantService.findById(3L);
        
        logger.info(k1.toString());
        logger.info(klantSample.get(0).toString());
        assertEquals(k1, klantSample.get(0));
        
        logger.info(k2.toString());
        logger.info(klantSample.get(1).toString());
        assertEquals(k2, klantSample.get(1));
    }
    
    //@Test
    public void testFind() {
        Map<String, String> searchParam = new HashMap<>();
        searchParam.put("voornaam", klantSample.get(0).getVoornaam());
        searchParam.put("achternaam", klantSample.get(0).getAchternaam());
        Adres[] adressen = (Adres[])klantSample.get(0).getAdressen().toArray();
        searchParam.put("adres.straatnaam", adressen[0].getStraatnaam());
        searchParam.put("adres.huisnummer", adressen[0].getHuisnummer());
        searchParam.put("adres.postcode", adressen[0].getPostcode());
        searchParam.put("adres.woonplaats", adressen[0].getWoonplaats());
        
        List<Klant> klanten = klantService.find(searchParam);
        
        logger.info(klanten.toString());
        assertEquals(klanten.get(0), klantSample.get(0));
    }
}

package org.workshop2.floorinxs.config;

import java.util.HashSet;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.workshop2.floorinxs.dao.KlantDao;
import org.workshop2.floorinxs.dao.KlantDaoImpl;
import org.workshop2.floorinxs.entity.Klant;
import org.workshop2.floorinxs.entity.Adres;
import org.workshop2.floorinxs.service.KlantService;
import org.workshop2.floorinxs.service.KlantServiceImpl;

@Configuration
@ImportResource("classpath:springtestconfig.xml")
@ComponentScan(basePackages = {"org.workshop2.floorinxs.dao", "org.workshop2.floorinxs.service"})
public class TestConfigurator {
    @Bean
    public KlantDao klantDao() {
        return new KlantDaoImpl();
    }
    
    @Bean
    public KlantService klantService() {
        return new KlantServiceImpl();
    }
    
    @Bean
    public Klant klant1() {
        Klant klant1 = new Klant();
        klant1.setVoornaam("Henk");
        klant1.setAchternaam("Hark");
        klant1.setEmailadres("henkie83@hotmail.com");
        klant1.setOpmerkingen("Vreemd");
        Set<Adres> adressen = new HashSet<>();
        Adres adres = new Adres();
        adres.setHuisnummer("34");
        adres.setPostcode("3452AB");
        adres.setStraatnaam("Straat in het Dorp");
        adres.setWoonplaats("Het Dorp");
        adressen.add(adres);
        klant1.setAdressen(adressen);
        return klant1;
    }
    
    @Bean 
    public Klant klant2() {
        Klant klant2 = new Klant();
        klant2.setVoornaam("Truus");
        klant2.setAchternaam("Trammelant");
        klant2.setEmailadres("truuhuuus@hotmail.com");
        klant2.setOpmerkingen("Geen opmerkingen");
        Set<Adres> adressen = new HashSet<>();
        Adres adres = new Adres();
        adres.setHuisnummer("101a");
        adres.setPostcode("6595ER");
        adres.setStraatnaam("Straat in de Stad");
        adres.setWoonplaats("De Stad");
        adressen.add(adres);
        klant2.setAdressen(adressen);
        return klant2;
    }
}

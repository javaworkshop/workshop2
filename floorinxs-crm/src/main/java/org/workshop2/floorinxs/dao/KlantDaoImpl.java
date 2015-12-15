package org.workshop2.floorinxs.dao;

import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.workshop2.floorinxs.entity.Klant;

@Repository
public class KlantDaoImpl extends AbstractDao<Klant, Long> implements KlantDao {
    
    @Override
    public void initLazyCollections(Klant klant) {
        Hibernate.initialize(klant.getFacturen());
        Hibernate.initialize(klant.getBestellingen());
    }
    
    @Override
    public Klant findByAdresAndNaam(String postcode, String huisnummer, String voornaam, String achternaam) {
        Query query = entityManager.createNamedQuery("Klant.byAdresAndNaam", entityClass);
        query.setParameter("postcode", postcode);
        query.setParameter("huisnummer", huisnummer);
        query.setParameter("voornaam", voornaam);
        query.setParameter("achternaam", achternaam);
        
        // Het is onwaarschijnlijk dat er twee mensen met dezelfde voor -en achternaam op hetzelfde
        // adres wonen, maar het kan gebeuren. Misschien standaard een list retourneren?
        try {
            return (Klant)query.getSingleResult();
        }
        catch(NonUniqueResultException ex) {
            return (Klant)query.getResultList().get(0);
        }
    }
}

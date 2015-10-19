package org.workshop2.floorinxs.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.workshop2.floorinxs.entity.Klant;

@Repository
public class KlantDaoImpl extends AbstractDao<Klant, Long> implements KlantDao {
    public void initLazyCollections(Klant klant) {
        Hibernate.initialize(klant.getFacturen());
        Hibernate.initialize(klant.getOffertes());
    }
}

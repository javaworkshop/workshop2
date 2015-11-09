package org.workshop2.floorinxs.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.workshop2.floorinxs.entity.Klant;

@Repository
public class KlantDaoImpl extends AbstractDao<Klant, Long> implements KlantDao {
    @Override
    public void initLazyCollections(Klant klant) {
        Hibernate.initialize(klant.getFacturen());
        Hibernate.initialize(klant.getBestellingen());
    }
}

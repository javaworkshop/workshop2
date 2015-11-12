package org.workshop2.floorinxs.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.workshop2.floorinxs.entity.Leverancier;

@Repository
public class LeverancierDaoImpl extends AbstractDao<Leverancier, Long> implements LeverancierDao {
    @Override
    public void initLazyCollections(Leverancier leverancier) {
//        Hibernate.initialize(leverancier.getFacturen());
//        Hibernate.initialize(leverancier.getOffertes());
    }
}

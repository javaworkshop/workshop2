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
        Hibernate.initialize(klant.getOffertes());
    }

    @Override
    public List<Klant> read(Map<String, String> searchParam) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Klant.class)
                .createAlias("adressen", "adres");
        
        for(String key : searchParam.keySet()) {
            if(!(searchParam.get(key).equals("")) && searchParam.get(key) != null )
                criteria.add(Restrictions.eq(key, searchParam.get(key)));
        }
        
        return criteria.list();
    }
}

package org.workshop2.floorinxs.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.workshop2.floorinxs.entity.Klant;

@Repository
public class KlantDaoImpl extends AbstractDao<Klant, Long> implements KlantDao {
    
}

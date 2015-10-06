package org.workshop2.floorinxs.doa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.workshop2.floorinxs.entity.Klant;

@Repository
@Transactional
public class KlantDaoImpl extends AbstractDao<Klant, Integer> implements KlantDao {
    
}

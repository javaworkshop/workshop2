package org.workshop2.floorinxs.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.workshop2.floorinxs.dao.AdresDao;
import org.workshop2.floorinxs.dao.KlantDao;
import org.workshop2.floorinxs.entity.Klant;

// TODO: eventuele bewerkingen en checks van data uitvoeren
@Service
@Transactional
public class KlantServiceImpl implements KlantService {
    @Autowired
    private KlantDao klantDao;
    private boolean eagerFetch = false;

    @Override
    public void delete(Klant klant) {
        klantDao.delete(klant);
    }

    @Override
    public List<Klant> findAll() {
        List<Klant> klantenResult = klantDao.readAll();
        if(eagerFetch) {            
            for(Klant k : klantenResult)
                klantDao.initLazyCollections(k);
        }

        return klantenResult;
    }

    @Override
    public Klant findById(long id) {
        Klant klantResult = klantDao.readById(id);
        if(eagerFetch) {            
            klantDao.initLazyCollections(klantResult);
        }
        
        return klantResult;
    }    

    @Override
    public List<Klant> find(Map<String, String> searchParam) {
        List<Klant> klantenResult = klantDao.read(searchParam);
        if(eagerFetch) {            
            for(Klant k : klantenResult)
                klantDao.initLazyCollections(k);
        }
        
        return klantenResult;
    }
    
    @Override
    public void setEagerFetch(boolean eagerFetch) {
        this.eagerFetch = eagerFetch;
    }    

    @Override
    public boolean isEagerFetch() {
        return eagerFetch;
    }

    @Override
    public void save(Klant klant) {
        // TODO: klantgegevens valideren
        klantDao.create(klant);
    }

    @Override
    public Klant update(Klant klant) {
        // TODO: klantgegevens valideren
        return klantDao.update(klant);
    }
}

package org.workshop2.floorinxs.service;

import java.util.List;
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
        List<Klant> klantenResult;
        if(eagerFetch) {
            klantenResult = klantDao.readAll();
            for(Klant k : klantenResult)
                klantDao.initLazyCollections(k);
        }
        else
            klantenResult = klantDao.readAll();
        return klantenResult;
    }

    @Override
    public Klant findById(long id) {
        Klant klantResult;
        if(eagerFetch) {
            klantResult = klantDao.readById(id);
            klantDao.initLazyCollections(klantResult);
        }
        else
            klantResult = klantDao.readById(id);
        
        return klantResult;
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

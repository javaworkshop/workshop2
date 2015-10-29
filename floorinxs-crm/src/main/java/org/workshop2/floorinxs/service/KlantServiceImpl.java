package org.workshop2.floorinxs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.workshop2.floorinxs.dao.KlantDao;
import org.workshop2.floorinxs.dto.SearchDto;
import org.workshop2.floorinxs.entity.Klant;

// TODO: eventuele bewerkingen en checks van data uitvoeren
@Service
@Transactional
public class KlantServiceImpl implements KlantService {
    @Autowired
    private KlantDao klantDao;
    private boolean eagerFetch = false;

    @Override
    public void delete(Klant klant) throws ServiceException {
        try {
            klantDao.delete(klant);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        } 
    }

    @Override
    public List<Klant> find(SearchDto SearchDto) throws ServiceException {
        try {
            List<Klant> klantenResult = klantDao.read(SearchDto);
            if(eagerFetch) {
                for(Klant k : klantenResult)
                    klantDao.initLazyCollections(k);
            }
            
            return klantenResult;
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Klant> findAll() throws ServiceException {
        try {
            List<Klant> klantenResult = klantDao.readAll();
            if(eagerFetch) {            
                for(Klant k : klantenResult)
                    klantDao.initLazyCollections(k);
            }

            return klantenResult;
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public Klant findById(long id) throws ServiceException {
        try {
            Klant klantResult = klantDao.readById(id);
            if(eagerFetch) {            
                klantDao.initLazyCollections(klantResult);
            }
        
            return klantResult;
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
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
    public void save(Klant klant) throws ServiceException {
        // TODO: klantgegevens valideren
        try {
            klantDao.create(klant);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public Klant update(Klant klant) throws ServiceException {
        // TODO: klantgegevens valideren
        try {
            return klantDao.update(klant);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex);
        }
    }
}

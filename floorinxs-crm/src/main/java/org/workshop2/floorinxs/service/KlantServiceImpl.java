package org.workshop2.floorinxs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public void delete(Klant klant) throws ServiceException {
        try {
            klantDao.delete(klant);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex);
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
            throw new ServiceException(ex);
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
            throw new ServiceException(ex);
        }
    }    

    @Override
    public List<Klant> find(Map<String, String> searchParam) throws ServiceException {        
        Map<String, String> aliases = new HashMap<>();
        // TODO: even kijken of hier een mooiere oplossing voor is
        for(String key : searchParam.keySet()) {
            // Kijk voor iedere key of bijbehorende waarde is ingevuld
            if(!searchParam.get(key).equals("")) {
                int dotIndex = key.indexOf('.');
                // als de key een '.' bevat moet er een alias aangemaakt worden om de 
                // associatietabel te kunnen benaderen                
                if(dotIndex != -1) {
                    String entityName = key.substring(0, dotIndex);
                    if(entityName.equals("adres"))
                        aliases.put("adressen", "adres");
                    else if(entityName.equals("factuur"))
                        aliases.put("facturen", "factuur");
                    else
                        aliases.put("offertes", "offerte");
                }
            }
        }
        
        try {
            List<Klant> klantenResult = klantDao.read(searchParam, aliases);
            if(eagerFetch) {            
                for(Klant k : klantenResult)
                    klantDao.initLazyCollections(k);
            }
            
            return klantenResult;
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex);
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
            throw new ServiceException(ex);
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

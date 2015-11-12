package org.workshop2.floorinxs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.workshop2.floorinxs.dao.LeverancierDao;
import org.workshop2.floorinxs.dto.SearchDto;
import org.workshop2.floorinxs.entity.Leverancier;

// TODO: eventuele bewerkingen en checks van data uitvoeren
@Service
@Transactional
public class LeverancierServiceImpl implements LeverancierService {
    @Autowired
    private LeverancierDao leverancierDao;
    private boolean eagerFetch = false;

    @Override
    public void delete(Leverancier leverancier) throws ServiceException {
        try {
            leverancierDao.delete(leverancier);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        } 
    }

    @Override
    public List<Leverancier> find(SearchDto SearchDto) throws ServiceException {
        try {
            List<Leverancier> leverancierenResult = leverancierDao.read(SearchDto);
            if(eagerFetch) {
                for(Leverancier k : leverancierenResult)
                    leverancierDao.initLazyCollections(k);
            }
            
            return leverancierenResult;
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Leverancier> findAll() throws ServiceException {
        try {
            List<Leverancier> leverancierenResult = leverancierDao.readAll();
            if(eagerFetch) {            
                for(Leverancier k : leverancierenResult)
                    leverancierDao.initLazyCollections(k);
            }

            return leverancierenResult;
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public Leverancier findById(long id) throws ServiceException {
        try {
            Leverancier leverancierResult = leverancierDao.readById(id);
            if(eagerFetch) {            
                leverancierDao.initLazyCollections(leverancierResult);
            }
        
            return leverancierResult;
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
    public void save(Leverancier leverancier) throws ServiceException {
        // TODO: leveranciergegevens valideren
        try {
            leverancierDao.create(leverancier);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public Leverancier update(Leverancier leverancier) throws ServiceException {
        // TODO: leveranciergegevens valideren
        try {
            return leverancierDao.update(leverancier);
        }
        catch(DataAccessException ex) {
            throw new ServiceException(ex);
        }
    }
}

package org.workshop2.floorinxs.service;

import java.util.List;
import org.workshop2.floorinxs.dto.SearchDto;
import org.workshop2.floorinxs.entity.Klant;

// Deze ook generic maken op dezelfde manier als dao's?
public interface KlantService {
    void save(Klant klant) throws ServiceException;    
    void delete(Klant klant) throws ServiceException;
    Klant update(Klant klant) throws ServiceException;
    Klant findById(long id) throws ServiceException;
    List<Klant> findAll() throws ServiceException;
    List<Klant> find(SearchDto SearchDto);
    /**
     * Forces collections that are normally lazily fetched to be fetched eagerly when set to true. 
     * When set to false, collections are fetched according to configuration. Is initially set to
     * false.
     * @param eagerFetch 
     */    
    void setEagerFetch(boolean eagerFetch) throws ServiceException;
    boolean isEagerFetch() throws ServiceException;
}

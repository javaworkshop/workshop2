package org.workshop2.floorinxs.service;

import java.util.List;
import org.workshop2.floorinxs.dto.SearchDto;
import org.workshop2.floorinxs.entity.Leverancier;

// Deze ook generic maken op dezelfde manier als dao's?
public interface LeverancierService {
    void save(Leverancier leverancier) throws ServiceException;    
    void delete(Leverancier leverancier) throws ServiceException;
    Leverancier update(Leverancier leverancier) throws ServiceException;
    Leverancier findById(long id) throws ServiceException;
    List<Leverancier> findAll() throws ServiceException;
    List<Leverancier> find(SearchDto SearchDto);
    /**
     * Forces collections that are normally lazily fetched to be fetched eagerly when set to true. 
     * When set to false, collections are fetched according to configuration. Is initially set to
     * false.
     * @param eagerFetch 
     */    
    void setEagerFetch(boolean eagerFetch) throws ServiceException;
    boolean isEagerFetch() throws ServiceException;
}

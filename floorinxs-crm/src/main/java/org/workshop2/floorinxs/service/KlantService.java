package org.workshop2.floorinxs.service;

import java.util.List;
import java.util.Map;
import org.workshop2.floorinxs.entity.Klant;

// Deze ook generic maken op dezelfde manier als dao's?
public interface KlantService {
    void save(Klant klant) throws ServiceException;    
    void delete(Klant klant) throws ServiceException;
    Klant update(Klant klant) throws ServiceException;
    Klant findById(long id) throws ServiceException;
    List<Klant> findAll() throws ServiceException;
    /**
     * Looks up klanten that correspond to the given search parameters.
     * @param searchParam   A map in which the search parameters are stored as values. Keys 
     *                      correspond to klant properties. If a property is another entity enter 
     *                      the key like this: entityname.propertyname. For instance, when adding 
     *                      an adres parameter, the key could be "adres.straatnaam". 
     * @return              A list of the klanten that were found.
     */
    List<Klant> find(Map<String, String> searchParam) throws ServiceException;
    /**
     * Forces collections that are normally lazily fetched to be fetched eagerly when set to true. 
     * When set to false, collections are fetched according to configuration. Is initially set to
     * false.
     * @param eagerFetch 
     */    
    void setEagerFetch(boolean eagerFetch) throws ServiceException;
    boolean isEagerFetch() throws ServiceException;
}

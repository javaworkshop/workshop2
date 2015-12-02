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
    Klant findById(long id, FetchMode fetchMode) throws ServiceException;
    List<Klant> findAll() throws ServiceException;
    List<Klant> findAll(FetchMode fetchMode) throws ServiceException;
    List<Klant> find(SearchDto SearchDto)throws ServiceException;
    List<Klant> find(SearchDto SearchDto, FetchMode fetchMode)throws ServiceException;
}

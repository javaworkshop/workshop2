package org.workshop2.floorinxs.dao;

import java.util.List;
import java.util.Map;
import org.workshop2.floorinxs.dto.SearchDto;

public interface Dao<E, PK> {
    void create(E entity);
    void delete(E entity);
    E update(E entity);
    E readById(PK id);
    List<E> readAll();
    List<E> read(SearchDto searchDto);
}

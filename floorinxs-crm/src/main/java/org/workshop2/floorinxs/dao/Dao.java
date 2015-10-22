package org.workshop2.floorinxs.dao;

import java.util.List;
import java.util.Map;

public interface Dao<E, PK> {
    void create(E entity);
    void delete(E entity);
    E update(E entity);
    E readById(PK id);
    List<E> readAll();
    List<E> read(Map<String, String> searchParam);
    List<E> read(Map<String, String> searchParam, Map<String, String> aliases);
}

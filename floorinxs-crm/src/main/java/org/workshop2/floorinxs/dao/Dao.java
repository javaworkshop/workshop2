package org.workshop2.floorinxs.dao;

import java.util.List;

public interface Dao<E, PK> {
    void create(E entity);
    void delete(E entity);
    E update(E entity);
    E readById(PK id);
    List<E> readAll();
}

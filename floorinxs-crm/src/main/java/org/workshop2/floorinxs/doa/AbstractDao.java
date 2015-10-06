package org.workshop2.floorinxs.doa;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class AbstractDao<E, PK> implements Dao<E, PK> {
    protected Class entityClass;
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    public AbstractDao() {
        ParameterizedType genericSuperClass = (ParameterizedType)getClass().getGenericSuperclass();
        entityClass = (Class)genericSuperClass.getActualTypeArguments()[0];
    }

    @Override
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<E> readAll() {
        Query query = entityManager.createQuery("from " + entityClass.getName());
        return query.getResultList();
    }

    @Override
    public E readById(PK id) {
        return (E)entityManager.find(entityClass, id);
    }

    @Override
    public E update(E entity) {
        return entityManager.merge(entity);
    }
    
}

package org.workshop2.floorinxs.dao;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
    
    @Override
    public List<E> read(Map<String, String> searchParam) {
        return read(searchParam, new HashMap<>());
    }
    
    @Override
    public List<E> read(Map<String, String> searchParam, Map<String, String> aliases) {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(entityClass);

        // create alias for every key-value (property-alias) pair
        for(String key : aliases.keySet()) {
            criteria.createAlias(key, aliases.get(key));
        }
        
        //add criterion for every key-value (property-parameter) pair
        for(String key : searchParam.keySet()) {
            if(!(searchParam.get(key).equals("")) && searchParam.get(key) != null )
                criteria.add(Restrictions.eq(key, searchParam.get(key)));
        }
        
        return criteria.list();
    }
}

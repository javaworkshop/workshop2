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
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.MultiValueMap;
import org.workshop2.floorinxs.dto.SearchDto;

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
    public List<E> read(SearchDto searchDto) {
        MultiValueMap<String, String> searchParam = searchDto.createSearchParamMap();
        Map<String, String> aliases = searchDto.createAliasesMap();        
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(entityClass);
        
        for(String property : searchParam.keySet()) {
            List<String> currentParams = searchParam.get(property);
            Disjunction or = Restrictions.disjunction();
            for(String param : currentParams)
                or.add(Restrictions.like(property, "%" + param + "%", MatchMode.ANYWHERE));
            criteria.add(or);
        }
        
        for(String property : aliases.keySet())
            criteria.createAlias(property, aliases.get(property));
        
        return criteria.list();
    }  
}

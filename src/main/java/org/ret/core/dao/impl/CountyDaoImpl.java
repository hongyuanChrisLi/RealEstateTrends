package org.ret.core.dao.impl;

import static org.ret.core.constant.SQLQueryConstant.SQL_ALL_COUNTIES;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.ret.core.dao.CountyDao;
import org.ret.core.entity.County;
import org.springframework.stereotype.Repository;

@Repository
public class CountyDaoImpl implements CountyDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<County> getAllCounties() {
        try {
            return entityManager.createQuery(SQL_ALL_COUNTIES).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}

package org.ret.dao.impl;

import static org.ret.constant.SQLQueryConstant.SQL_MLS_PROP_BY_ID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.ret.dao.MlsPropDao;
import org.ret.entity.MlsProp;
import org.springframework.stereotype.Repository;

@Repository
public class MlsPropDaoImpl implements MlsPropDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public MlsProp findMlsPropById(String MlsId) {
        MlsProp mlsProp;
        
        try {
            mlsProp = (MlsProp) entityManager.createQuery(SQL_MLS_PROP_BY_ID).setParameter("mlsId", MlsId)
                    .getSingleResult();
            return mlsProp;
        } catch (NoResultException e) {
            return null;
        }
    }

}

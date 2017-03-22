package org.ret.core.dao.impl;

import static org.ret.core.constant.SQLQueryConstant.SQL_MLS_DAILY_RPT;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.ret.core.dao.MlsDailyRptDao;
import org.ret.core.entity.MlsDailyRpt;
import org.springframework.stereotype.Repository;

@Repository
public class MlsDailyRptDaoImpt implements MlsDailyRptDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public MlsDailyRpt getMlsDailyRpts(Integer countyId, Integer cityId) {
        try {
            return (MlsDailyRpt) entityManager
                    .createQuery(SQL_MLS_DAILY_RPT)
                    .setParameter("countyId", countyId)
                    .setParameter("cityId", cityId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}

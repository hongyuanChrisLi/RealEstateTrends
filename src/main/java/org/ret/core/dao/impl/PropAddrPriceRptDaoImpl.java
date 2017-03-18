package org.ret.core.dao.impl;

import static org.ret.core.constant.SQLQueryConstant.SQL_PROP_ADDR_PRICE_RPTS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.ret.core.dao.PropAddrPriceRptDao;
import org.ret.core.entity.PropAddrPriceRpt;
import org.springframework.stereotype.Repository;

@Repository
public class PropAddrPriceRptDaoImpl implements PropAddrPriceRptDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<PropAddrPriceRpt> getPropAddrPriceRpts(Integer countyId, Integer cityId, String zipcode,
            Integer propTypeId) {
        try {
            return entityManager
                    .createQuery(SQL_PROP_ADDR_PRICE_RPTS)
                    .setParameter("countyId", countyId)
                    .setParameter("cityId", cityId)
                    .setParameter("zipcode", zipcode)
                    .setParameter("propTypeId", propTypeId)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    

}

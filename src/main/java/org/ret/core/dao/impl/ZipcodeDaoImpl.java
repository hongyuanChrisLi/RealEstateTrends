package org.ret.core.dao.impl;

import static org.ret.core.constant.SQLQueryConstant.SQL_CITY_ZIPCODES;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.ret.core.dao.ZipcodeDao;
import org.ret.core.entity.City;
import org.ret.core.entity.Zipcode;
import org.springframework.stereotype.Repository;

@Repository
public class ZipcodeDaoImpl implements ZipcodeDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Zipcode> getCityZipcodes(City city) {
        try {
            return entityManager.createQuery(SQL_CITY_ZIPCODES)
                    .setParameter("city", city)
                    .getResultList();
            } catch (NoResultException e) {
            return null;
        }
    }

}

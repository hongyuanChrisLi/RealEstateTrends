package org.ret.core.dao.impl;

import static org.ret.core.constant.SQLQueryConstant.SQL_CITY_BY_ID;
import static org.ret.core.constant.SQLQueryConstant.SQL_COUNTY_CITIES;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.ret.core.dao.CityDao;
import org.ret.core.entity.City;
import org.ret.core.entity.County;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl implements CityDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<City> getCountyCities(County county) { 
        try {
            return entityManager.createQuery(SQL_COUNTY_CITIES)
                    .setParameter("county", county)
                    .getResultList();
            } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public City getCityById(Integer cityId) {
        try {
            return (City) entityManager
                    .createQuery(SQL_CITY_BY_ID)
                    .setParameter("cityId", cityId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}

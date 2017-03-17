package org.ret.core.dao;

import java.util.List;

import org.ret.core.entity.City;
import org.ret.core.entity.County;

public interface CityDao {
    
    List<City> getCountyCities(County county);
    
    City getCityById(Integer cityId);
}

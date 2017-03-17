package org.ret.core.dao;

import java.util.List;

import org.ret.core.entity.City;
import org.ret.core.entity.Zipcode;

public interface ZipcodeDao {
    
    List<Zipcode> getCityZipcodes(City city);
}

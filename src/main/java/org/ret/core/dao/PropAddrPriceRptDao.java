package org.ret.core.dao;

import java.util.List;

import org.ret.core.entity.City;
import org.ret.core.entity.County;
import org.ret.core.entity.PropAddrPriceRpt;

public interface PropAddrPriceRptDao {
    
    List<PropAddrPriceRpt> getPropAddrPriceRpts(
            Integer countyId, Integer cityId, String zipcode, Integer propTypeId);
}

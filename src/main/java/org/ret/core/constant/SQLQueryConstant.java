package org.ret.core.constant;

public interface SQLQueryConstant {
    String SQL_MLS_PROP_BY_ID = "from MlsProp where mlsId = :mlsId";
    
    String SQL_ALL_COUNTIES = "from County";
    String SQL_COUNTY_BY_ID = "from County where countyId = :countyId";
    
    String SQL_COUNTY_CITIES = "from City where county = :county";
    String SQL_CITY_BY_ID = "from City where cityId = :cityId";
    
    String SQL_CITY_ZIPCODES = "from Zipcode where city = :city";
}

package org.ret.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mls_daily_rpt")
public class MlsDailyRpt implements Serializable {

    private static final long serialVersionUID = -2616804921217610346L;
    
    @Id
    @Column(name="COUNTY_ID")
    private Integer countyId;
    
    @Id
    @Column(name="CITY_ID")
    private Integer cityId;
    
    @Column(name="AVG_PRICE_STRUCT_SQFT")
    private Float avgPriceStructSqft;
    
    @Column(name="AVG_PRICE_TOT_SQFT")
    private Float avgPriceTotSqft;
    
    @Column(name="SINGLE_FAMILY_NUM")
    private Integer singleFamilyNum;
    
    @Column(name="TOWNHOUSE_NUM")
    private Integer townhouseNum;
    
    @Column(name="CONDO_NUM")
    private Integer condoNum;
    
    @Column(name="MULTI_UNIT_NUM")
    private Integer multiUnitNum;
    
    @Column(name="MOBILE_NUM")
    private Integer mobileNum;
    
    @Column(name="TOT_NUM")
    private Integer totNum;

    public Integer getCountyId() {
        return countyId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public Float getAvgPriceStructSqft() {
        return avgPriceStructSqft;
    }

    public Float getAvgPriceTotSqft() {
        return avgPriceTotSqft;
    }

    public Integer getSingleFamilyNum() {
        return singleFamilyNum;
    }

    public Integer getTownhouseNum() {
        return townhouseNum;
    }

    public Integer getCondoNum() {
        return condoNum;
    }

    public Integer getMultiUnitNum() {
        return multiUnitNum;
    }

    public Integer getMobileNum() {
        return mobileNum;
    }

    public Integer getTotNum() {
        return totNum;
    }
}

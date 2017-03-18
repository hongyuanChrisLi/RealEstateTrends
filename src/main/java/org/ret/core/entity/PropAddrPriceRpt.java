package org.ret.core.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prop_addr_price_rpt")
public class PropAddrPriceRpt implements Serializable {

    private static final long serialVersionUID = 944508793944047953L;
    
    @Id
    @Column(name="RPT_ID")
    private Integer rptId;
    
    @Column(name="COUNTY_ID")
    private Integer countyId;
    
    @Column(name="CITY_ID")
    private Integer cityId;
    
    @Column(name="ZIPCODE")
    private String zipcode;
    
    @Column(name="PROP_TYPE_ID")
    private Integer propTypeId;
    
    @Column(name="RPT_DATE")
    private Date rptDate;
    
    @Column(name="AVG_PRICE")
    private Float avgPrice;
    
    @Column(name="AVG_PRICE_STRUCT_SQFT")
    private Float avgPriceStructSqft;
    
    @Column(name="AVG_PRICE_TOT_SQFT")
    private Float avgPriceTotSqft;

    public Integer getRptId() {
        return rptId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Integer getPropTypeId() {
        return propTypeId;
    }

    public Date getRptDate() {
        return rptDate;
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public Float getAvgPriceStructSqft() {
        return avgPriceStructSqft;
    }

    public Float getAvgPriceTotSqft() {
        return avgPriceTotSqft;
    }
    

}

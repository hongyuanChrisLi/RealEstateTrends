package org.ret.admin.service.dto;

import java.sql.Date;

public class PropAddrPriceRptDto {
    
    private Integer rptId;
    private Integer countyId;
    private Integer cityId;
    private String zipcode;
    private Integer propTypeId;
    private Date rptDate;
    private Float avgPrice;
    private Float avgPriceStructSqft;
    private Float avgPriceTotSqft;
    
    public Integer getRptId() {
        return rptId;
    }
    public void setRptId(Integer rptId) {
        this.rptId = rptId;
    }
    public Integer getCountyId() {
        return countyId;
    }
    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }
    public Integer getCityId() {
        return cityId;
    }
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public Integer getPropTypeId() {
        return propTypeId;
    }
    public void setPropTypeId(Integer propTypeId) {
        this.propTypeId = propTypeId;
    }
    public Date getRptDate() {
        return rptDate;
    }
    public void setRptDate(Date rptDate) {
        this.rptDate = rptDate;
    }
    public Float getAvgPrice() {
        return avgPrice;
    }
    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }
    public Float getAvgPriceStructSqft() {
        return avgPriceStructSqft;
    }
    public void setAvgPriceStructSqft(Float avgPriceStructSqft) {
        this.avgPriceStructSqft = avgPriceStructSqft;
    }
    public Float getAvgPriceTotSqft() {
        return avgPriceTotSqft;
    }
    public void setAvgPriceTotSqft(Float avgPriceTotSqft) {
        this.avgPriceTotSqft = avgPriceTotSqft;
    }
   
}

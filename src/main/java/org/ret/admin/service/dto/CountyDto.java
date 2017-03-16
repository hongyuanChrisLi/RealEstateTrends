package org.ret.admin.service.dto;

public class CountyDto {

    private int countyId;
    private String county;
    
    public int getCountyId() {
        return countyId;
    }
    
    public String getCounty() {
        return county;
    }
    
    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }
    
    public void setCounty(String county) {
        this.county = county;
    }
}

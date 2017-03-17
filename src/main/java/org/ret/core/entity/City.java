package org.ret.core.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="city")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class City implements Serializable{

    private static final long serialVersionUID = 8224159162653666213L;

    @Id
    @Column(name="CITY_ID")
    private Integer cityId;

    @Column(name="NAME")
    private String city;
    
    @ManyToOne
    @JoinColumn(name="COUNTY_ID")
    private County county;

    public Integer getCityId() {
        return cityId;
    }
    
    public String getCity() {
        return city;
    }
    
    public County getCounty() {
        return county;
    }


}

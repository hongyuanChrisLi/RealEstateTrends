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
@Table(name="zipcode")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Zipcode implements Serializable{

    private static final long serialVersionUID = -2591179742871642538L;
    
    @Id
    @Column(name="AREA_ID")
    private Integer areaId;

    @Column(name="ZIPCODE")
    private String zipcode;

    @ManyToOne
    @JoinColumn(name="CITY_ID")
    private City city;

    public Integer getAreaId() {
        return areaId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public City getCity() {
        return city;
    }

}

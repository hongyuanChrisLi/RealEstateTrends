package org.ret.core.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="county")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class County implements Serializable{

    private static final long serialVersionUID = -2591179742871642538L;
    
    @Id
    @Column(name="COUNTY_ID")
    private Integer countyId;

    @Column(name="NAME")
    private String county;

    public Integer getCountyId() {
        return countyId;
    }

    public String getCounty() {
        return county;
    }

}

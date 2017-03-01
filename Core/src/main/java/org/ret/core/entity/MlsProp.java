package org.ret.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mls_prop_fact")
public class MlsProp implements Serializable {

    private static final long serialVersionUID = 6728177547214253780L;
    
    @Id
    @Column(name="MLS_ID")
    private String mlsId;
    
    @Column(name="ADDR")
    private String addr;
    
    public String getMlsId(){
        return mlsId; 
    }
    
    public String getAddr(){
        return addr;
    }

}

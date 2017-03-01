package org.ret.admin.service.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MlsPropDto {

    @JsonInclude(value = NON_NULL)
    @Length(max = 14)
    private String mlsId;
    
    @JsonInclude(value = NON_NULL)
    @Length(max = 50)
    private String addr;

    public String getMlsId() {
        return mlsId;
    }

    public void setMlsId(String mlsId) {
        this.mlsId = mlsId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    
}

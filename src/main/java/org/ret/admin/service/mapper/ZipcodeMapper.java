package org.ret.admin.service.mapper;

import org.ret.admin.service.dto.ZipcodeDto;
import org.ret.core.entity.Zipcode;

public class ZipcodeMapper {

    public static ZipcodeDto toDto(Zipcode pojo){
        if (pojo == null)
            return null;
        
        ZipcodeDto zipcodeDto = new ZipcodeDto();
        zipcodeDto.setZipcode(pojo.getZipcode());

        return zipcodeDto;
    }
    
}

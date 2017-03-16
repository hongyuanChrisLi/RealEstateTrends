package org.ret.admin.service.mapper;

import org.ret.admin.service.dto.CountyDto;
import org.ret.core.entity.County;

public class CountyMapper {

    public static CountyDto toDto(County pojo){
        if (pojo == null)
            return null;
        
        CountyDto mlsPropDto = new CountyDto();
        mlsPropDto.setCountyId(pojo.getCountyId());
        mlsPropDto.setCounty(pojo.getCounty());
        
        return mlsPropDto;
    }
    
}

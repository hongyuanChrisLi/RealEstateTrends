package org.ret.admin.service.mapper;

import org.ret.admin.service.dto.CityDto;
import org.ret.core.entity.City;

public class CityMapper {

    public static CityDto toDto(City pojo){
        if (pojo == null)
            return null;
        
        CityDto cityDto = new CityDto();
        cityDto.setCityId(pojo.getCityId());
        cityDto.setCity(pojo.getCity());
        
        return cityDto;
    }
    
}

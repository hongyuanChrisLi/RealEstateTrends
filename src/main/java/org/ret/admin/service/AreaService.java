package org.ret.admin.service;

import java.util.List;

import org.ret.admin.service.dto.CityDto;
import org.ret.admin.service.dto.CountyDto;
import org.ret.admin.service.dto.ZipcodeDto;

public interface AreaService {

    List<CountyDto> getAllCountyDtos();
    
    List<CityDto> getCountyCityDtos(Integer countyId);
    
    List<ZipcodeDto> getCityZipcodeDtos(Integer cityId);
}

package org.ret.admin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.ret.admin.service.AreaService;
import org.ret.admin.service.dto.CityDto;
import org.ret.admin.service.dto.CountyDto;
import org.ret.admin.service.dto.ZipcodeDto;
import org.ret.admin.service.mapper.CountyMapper;
import org.ret.admin.service.mapper.ZipcodeMapper;
import org.ret.admin.service.mapper.CityMapper;
import org.ret.core.dao.CountyDao;
import org.ret.core.dao.ZipcodeDao;
import org.ret.core.entity.City;
import org.ret.core.entity.County;
import org.ret.core.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    CountyDao countyDao;
    
    @Autowired
    CityDao cityDao;
    
    @Autowired
    ZipcodeDao zipcodeDao;
    
    @Override
    public List<CountyDto> getAllCountyDtos() {
        return countyDao.getAllCounties()
                .stream()
                .map(CountyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CityDto> getCountyCityDtos(Integer countyId) {
        County county = countyDao.getCountyById(countyId);
        if (county != null){
            return cityDao.getCountyCities(county)
                    .stream()
                    .map(CityMapper::toDto)
                    .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public List<ZipcodeDto> getCityZipcodeDtos(Integer cityId) {
        City city = cityDao.getCityById(cityId);
        
        if (city != null){
            return zipcodeDao.getCityZipcodes(city)
                    .stream()
                    .map(ZipcodeMapper::toDto)
                    .collect(Collectors.toList());
        }
        return null;
    }

}

package org.ret.admin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.ret.admin.service.CountyService;
import org.ret.admin.service.dto.CountyDto;
import org.ret.admin.service.mapper.CountyMapper;
import org.ret.core.dao.CountyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountyServiceImpl implements CountyService {

    @Autowired
    CountyDao countyDao;
    
    @Override
    public List<CountyDto> getAllCountyDto() {
        return countyDao.getAllCounties()
                .stream()
                .map(CountyMapper::toDto)
                .collect(Collectors.toList());
    }

}

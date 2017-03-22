package org.ret.admin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.ret.admin.service.PriceRptService;
import org.ret.admin.service.dto.MlsDailyRptDto;
import org.ret.admin.service.dto.PropAddrPriceRptDto;
import org.ret.admin.service.mapper.MlsDailyRptMapper;
import org.ret.admin.service.mapper.PropAddrPriceRptMapper;
import org.ret.core.dao.MlsDailyRptDao;
import org.ret.core.dao.PropAddrPriceRptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceRptServiceImpl implements PriceRptService {
    
    @Autowired
    PropAddrPriceRptDao propAddrPriceRptDao;
    
    @Autowired
    MlsDailyRptDao mlsDailyRptDao;

    @Override
    public List<PropAddrPriceRptDto> getPropAddrPriceRpts(Integer countyId, Integer cityId, String zipcode,
            Integer propTypeId) {
        return propAddrPriceRptDao.getPropAddrPriceRpts(countyId, cityId, zipcode, propTypeId)
                .stream()
                .map(PropAddrPriceRptMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MlsDailyRptDto getMlsDailyRptDtos(Integer countyId, Integer cityId) {
        return MlsDailyRptMapper.toDto(mlsDailyRptDao.getMlsDailyRpts(countyId, cityId));
    }

}

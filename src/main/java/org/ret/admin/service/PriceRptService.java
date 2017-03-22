package org.ret.admin.service;

import java.util.List;

import org.ret.admin.service.dto.MlsDailyRptDto;
import org.ret.admin.service.dto.PropAddrPriceRptDto;

public interface PriceRptService {
    
    List<PropAddrPriceRptDto> getPropAddrPriceRpts(
            Integer countyId, Integer cityId, String zipcode, Integer propTypeId);
    
    MlsDailyRptDto getMlsDailyRptDtos (Integer countyId, Integer cityId);
}

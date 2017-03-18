package org.ret.admin.service.mapper;

import org.ret.admin.service.dto.PropAddrPriceRptDto;
import org.ret.core.entity.PropAddrPriceRpt;

public class PropAddrPriceRptMapper {
    
    public static PropAddrPriceRptDto toDto(PropAddrPriceRpt pojo){
        if (pojo == null)
            return null;
        
        PropAddrPriceRptDto propAddrPriceDto = new PropAddrPriceRptDto();
        propAddrPriceDto.setRptId(pojo.getRptId());
        propAddrPriceDto.setCountyId(pojo.getCountyId());
        propAddrPriceDto.setCityId(pojo.getCityId());
        propAddrPriceDto.setZipcode(pojo.getZipcode());
        propAddrPriceDto.setPropTypeId(pojo.getPropTypeId());
        propAddrPriceDto.setRptDate(pojo.getRptDate());
        propAddrPriceDto.setAvgPrice(pojo.getAvgPrice());
        propAddrPriceDto.setAvgPriceStructSqft(pojo.getAvgPriceStructSqft());
        propAddrPriceDto.setAvgPriceTotSqft(pojo.getAvgPriceTotSqft());
        
        return propAddrPriceDto;
    }
}

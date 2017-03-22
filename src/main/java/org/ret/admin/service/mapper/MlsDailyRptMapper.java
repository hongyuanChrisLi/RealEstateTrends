package org.ret.admin.service.mapper;

import org.ret.admin.service.dto.MlsDailyRptDto;
import org.ret.core.entity.MlsDailyRpt;

public class MlsDailyRptMapper {
    
    public static MlsDailyRptDto toDto(MlsDailyRpt pojo){
        if (pojo == null)
            return null;
        
        MlsDailyRptDto mlsDailyRptDto = new MlsDailyRptDto();
        mlsDailyRptDto.setCountyId(pojo.getCountyId());
        mlsDailyRptDto.setCityId(pojo.getCityId());
        mlsDailyRptDto.setAvgPriceStructSqft(pojo.getAvgPriceStructSqft());
        mlsDailyRptDto.setAvgPriceTotSqft(pojo.getAvgPriceTotSqft());
        mlsDailyRptDto.setSingleFamilyNum(pojo.getSingleFamilyNum());
        mlsDailyRptDto.setTownhouseNum(pojo.getTownhouseNum());
        mlsDailyRptDto.setCondoNum(pojo.getCondoNum());
        mlsDailyRptDto.setMultiUnitNum(pojo.getMultiUnitNum());
        mlsDailyRptDto.setMobileNum(pojo.getMobileNum());
        
        return mlsDailyRptDto;
    }
}

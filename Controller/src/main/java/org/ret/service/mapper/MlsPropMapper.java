package org.ret.service.mapper;

import org.ret.entity.MlsProp;
import org.ret.service.dto.MlsPropDto;

public class MlsPropMapper {
    
    public static MlsPropDto toDto(MlsProp pojo){
        if (pojo == null)
            return null;
        
        MlsPropDto mlsPropDto = new MlsPropDto();
        mlsPropDto.setMlsId(pojo.getMlsId());
        mlsPropDto.setAddr(pojo.getAddr());
        
        return mlsPropDto;
    }
}

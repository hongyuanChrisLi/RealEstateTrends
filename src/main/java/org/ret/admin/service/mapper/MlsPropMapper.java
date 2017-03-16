package org.ret.admin.service.mapper;

import org.ret.admin.service.dto.MlsPropDto;
import org.ret.core.entity.MlsProp;

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

package org.ret.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ret.admin.service.MlsPropService;
import org.ret.admin.service.dto.MlsPropDto;
import org.ret.admin.service.mapper.MlsPropMapper;
import org.ret.core.dao.MlsPropDao;

@Service
public class MlsPropServiceImpl implements MlsPropService {

    @Autowired
    MlsPropDao mlsPropDao;
    
    @Override
    public MlsPropDto getMlsProp(String mlsId) {
        return MlsPropMapper.toDto(mlsPropDao.findMlsPropById(mlsId));
    }

}

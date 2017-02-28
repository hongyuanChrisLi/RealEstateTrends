package org.ret.service.impl;

import org.ret.service.MlsPropService;
import org.ret.service.dto.MlsPropDto;
import org.ret.service.mapper.MlsPropMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ret.dao.MlsPropDao;

@Service
public class MlsPropServiceImpl implements MlsPropService {

    @Autowired
    MlsPropDao mlsPropDao;
    
    @Override
    public MlsPropDto getMlsProp(String mlsId) {
        return MlsPropMapper.toDto(mlsPropDao.findMlsPropById(mlsId));
    }

}

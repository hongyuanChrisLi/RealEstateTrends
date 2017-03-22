package org.ret.core.dao;

import org.ret.core.entity.MlsDailyRpt;

public interface MlsDailyRptDao {
    MlsDailyRpt getMlsDailyRpts(Integer countyId, Integer cityId);
}

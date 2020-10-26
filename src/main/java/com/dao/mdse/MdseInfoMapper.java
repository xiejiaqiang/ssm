package com.dao.mdse;

import com.base.dao.BaseMapper;
import com.entity.po.Example.mdse.TMdseInfoExample;
import com.entity.po.mdse.TMdseInfo;

import java.math.BigDecimal;
import java.util.List;

public interface MdseInfoMapper extends BaseMapper<TMdseInfo> {

    List<TMdseInfo> selectMdseInfoAndMdsePrice(TMdseInfoExample example);

    Integer mdseInfoMdseCount();
}
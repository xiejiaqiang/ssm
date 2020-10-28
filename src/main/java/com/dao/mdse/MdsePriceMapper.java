package com.dao.mdse;

import com.base.dao.BaseMapper;
import com.entity.po.Example.mdse.TMdseInfoExample;
import com.entity.po.mdse.TMdseInfo;
import com.entity.po.mdse.TMdsePrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MdsePriceMapper extends BaseMapper<TMdsePrice> {

    List<TMdsePrice> selectMdsePrice(TMdseInfoExample example);
    long  deleteByMdseNo(@Param("list")List<Long> ids);
}
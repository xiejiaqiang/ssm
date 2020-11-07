package com.dao.mdse;

import com.base.dao.BaseMapper;
import com.entity.po.Example.mdse.TMdseSalesExample;
import com.entity.po.mdse.TMdseSales;

import java.util.List;

public interface MdseSalesMapper extends BaseMapper<TMdseSales> {

    List<TMdseSales> selectMdseSalesAndMdseInfo(TMdseSalesExample example);



}
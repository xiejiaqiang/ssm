package com.dao.mdse;

import com.base.dao.BaseMapper;
import com.entity.po.mdse.TMdseRegion;

import java.util.List;

public interface MdseRegionMapper extends BaseMapper<TMdseRegion> {

    List<TMdseRegion> selectMdseRegionInfo(List<String> list);

    List<TMdseRegion> selectMdseRegionByMdseNoGroup(String list);

    List<TMdseRegion> findMdseRegionGroupMdseNo(String list);

}
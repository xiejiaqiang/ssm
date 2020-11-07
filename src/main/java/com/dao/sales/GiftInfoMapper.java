package com.dao.sales;

import com.base.dao.BaseMapper;
import com.entity.po.Example.sales.TGiftInfoExample;
import com.entity.po.sales.TGiftInfo;

import java.util.List;

public interface GiftInfoMapper extends BaseMapper<TGiftInfo> {
    List<TGiftInfo> selectGiftInfo(TGiftInfoExample example);
}

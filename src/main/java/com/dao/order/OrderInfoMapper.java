package com.dao.order;

import com.base.dao.BaseMapper;
import com.entity.po.Example.payOrder.TOrderInfoExample;
import com.entity.po.payOrder.TOrderInfo;

import java.util.List;

public interface OrderInfoMapper extends BaseMapper<TOrderInfo> {

    List<TOrderInfo> selectOrderInfoAndMdseInfo(TOrderInfoExample example);
}
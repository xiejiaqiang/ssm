package com.dao.order;

import com.base.dao.BaseMapper;
import com.entity.po.Example.payOrder.TOrderInfoExample;
import com.entity.po.order.TOrderInfo;

import java.math.BigDecimal;
import java.util.List;

public interface OrderInfoMapper extends BaseMapper<TOrderInfo> {

    List<TOrderInfo> selectOrderInfoAndMdseInfo(TOrderInfoExample example);

    List<TOrderInfo> selectOrderInfoByGroupDate(TOrderInfoExample example);

    List<TOrderInfo> selectOrderInfoByDate(TOrderInfoExample example);

    BigDecimal orderInfoCountAmount();

    Integer orderInfoCount();

    List<TOrderInfo> selectOrderInfo(Integer size);
}
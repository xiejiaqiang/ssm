package com.service.impl.sales;

import com.dao.sales.GiftInfoMapper;
import com.entity.po.Example.sales.TGiftInfoExample;
import com.entity.po.sales.TGiftInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.service.sales.IGiftInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service("giftInfoService")
public class GiftInfoServiceImpl implements IGiftInfoService {
    static Logger LOGGER = LoggerFactory.getLogger(GiftInfoServiceImpl.class);
    @Autowired
    GiftInfoMapper giftInfoMapper;
    @Override
    public List<TGiftInfo> findGiftInfo(TGiftInfo t) throws Exception {
        return giftInfoMapper.select(t);
    }

    @Override
    public Integer countGiftInfo(TGiftInfo t) throws Exception {
        return giftInfoMapper.selectCount(t);
    }

    @Override
    public TGiftInfo findGiftInfoById(Long id) throws Exception {
        return giftInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public TGiftInfo findGiftInfoByGiftNo(String GiftNo) throws Exception {
        TGiftInfo GiftInfo = new TGiftInfo();
        GiftInfo.setGiftNo(GiftNo);
        return giftInfoMapper.selectOne(GiftInfo);
    }

    @Override
    public Integer addGiftInfo(TGiftInfo t) throws Exception {
        return giftInfoMapper.insert(t);
    }

    @Override
    public Integer updateGiftInfo(TGiftInfo t) throws Exception {
        return giftInfoMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public Integer deleteGiftInfo(Long id) throws Exception {
        return giftInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<TGiftInfo> findGiftInfo(TGiftInfo t, int pageNum, int pageSize, String ordername, String order) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        ordername = StringUtil.isNotEmpty(ordername)?ordername:"id";
        order = StringUtil.isNotEmpty(order)?order:"desc";
        TGiftInfoExample example = new TGiftInfoExample();
        example.setOrderByClause(ordername+" "+order);
        TGiftInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(t.getGiftName())){
            criteria.andGiftnameLike("%"+t.getGiftName()+"%");
        }
        if(StringUtil.isNotEmpty(t.getGiftNo())){
            criteria.andGiftnoEqualTo(t.getGiftNo());
        }
        List<TGiftInfo> list = giftInfoMapper.selectGiftInfo(example);
        PageInfo<TGiftInfo> pageInfo = new PageInfo<TGiftInfo>(list);
        return pageInfo;
    }
}

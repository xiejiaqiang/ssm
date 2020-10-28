package com.service.impl.mdse;

import com.dao.mdse.MdseInfoMapper;
import com.dao.mdse.MdsePriceMapper;
import com.entity.po.Example.mdse.TMdseInfoExample;
import com.entity.po.Example.mdse.TMdsePriceExample;
import com.entity.po.Example.payOrder.TOrderInfoExample;
import com.entity.po.mdse.TMdsePrice;
import com.service.impl.order.OrderInfoServiceImpl;
import com.service.mdse.IMdsePriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mdsePriceService")
public class MdsePriceServiceImpl implements IMdsePriceService {
    static Logger LOGGER = LoggerFactory.getLogger(MdsePriceServiceImpl.class);
    @Autowired
    MdsePriceMapper mdsePriceMapper;
    @Override
    public TMdsePrice findMdsePrice(Long id) throws Exception {
        return mdsePriceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TMdsePrice> findMdsePrice(TMdsePrice t) throws Exception {
        return mdsePriceMapper.select(t);
    }

    @Override
    public Integer countMdsePrice(TMdsePrice t) throws Exception {
        return mdsePriceMapper.selectCount(t);
    }

    @Override
    public Integer deleteMdsePrice(Long id) throws Exception {
       return mdsePriceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer addMdsePrice(TMdsePrice t) throws Exception {
        return mdsePriceMapper.insert(t);
    }

    @Override
    public Integer updateMdsePrice(TMdsePrice t) throws Exception {
        return mdsePriceMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public TMdsePrice findMdsePriceByMdseNo(String mdseNo) throws Exception {
        TMdsePrice mdsePrice = new TMdsePrice();
        mdsePrice.setMdseNo(mdseNo);
        List<TMdsePrice> list = mdsePriceMapper.select(mdsePrice);
        return list!=null?list.get(0):null;
    }

    @Override
    public boolean existMdsePriceWithMdseNo(String mdseNo) throws Exception {
        TMdsePrice mdsePrice = new TMdsePrice();
        mdsePrice.setMdseNo(mdseNo);
        return mdsePriceMapper.selectCount(mdsePrice)>0?true:false;
    }

    @Override
    public void deleteByMdseNos(List<Long> ids) throws Exception {
        mdsePriceMapper.deleteByMdseNo(ids);
    }

    @Override
    public void deleteByMdseNo(String mdseNo) throws Exception {
        TOrderInfoExample example = new TOrderInfoExample();
        TOrderInfoExample.Criteria criteria = example.createCriteria();
        criteria.andMdsenoNotEqualTo(mdseNo);
        mdsePriceMapper.deleteByExample(example);
    }
}

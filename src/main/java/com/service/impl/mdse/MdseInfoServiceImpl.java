package com.service.impl.mdse;

import com.dao.mdse.MdseInfoMapper;
import com.entity.po.Example.mdse.TMdseInfoExample;
import com.entity.po.Example.payOrder.TOrderInfoExample;
import com.entity.po.mdse.TMdseInfo;
import com.entity.po.order.TOrderInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.service.impl.order.OrderInfoServiceImpl;
import com.service.mdse.IMdseInfoService;
import com.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("mdseInfoService")
public class MdseInfoServiceImpl implements IMdseInfoService {
    static Logger LOGGER = LoggerFactory.getLogger(OrderInfoServiceImpl.class);
    @Autowired
    MdseInfoMapper mdseInfoMapper;
    @Override
    public List<TMdseInfo> findMdseInfo(TMdseInfo t) throws Exception {
        return mdseInfoMapper.select(t);
    }

    @Override
    public Integer countMdseInfo(TMdseInfo t) throws Exception {
        return mdseInfoMapper.selectCount(t);
    }

    @Override
    public TMdseInfo findMdseInfoById(Long id) throws Exception {
        return mdseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addMdseInfo(TMdseInfo t) throws Exception {
        return mdseInfoMapper.insert(t);
    }

    @Override
    public Integer updateMdseInfo(TMdseInfo t) throws Exception {
        return mdseInfoMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public Integer deleteMdseInfo(Long id) throws Exception {
        return mdseInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<TMdseInfo> findMdseInfo(TMdseInfo t, int pageNum, int pageSize, String ordername, String order, BigDecimal start, BigDecimal end,List<String> mdseCats) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        ordername = StringUtil.isNotEmpty(ordername)?ordername:"id";
        order = StringUtil.isNotEmpty(order)?order:"desc";
        TMdseInfoExample example = new TMdseInfoExample();
        example.setOrderByClause(ordername+" "+order);
        TMdseInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(t.getMdseName())){
            criteria.andMdsenameLike("%"+t.getMdseName()+"%");
        }
        if(StringUtil.isNotEmpty(t.getModel())){
            criteria.andModelLike(t.getModel());
        }
        if(StringUtil.isNotEmpty(t.getColour())){
            criteria.andColourLike(t.getColour());
        }
        if(mdseCats !=null && mdseCats.size()>0){
            criteria.andMdsecatIn(mdseCats);
        }
        if(StringUtil.isNotEmpty(t.getMdseStatus())){
            criteria.andMdsestatusEqualTo(t.getMdseStatus());
        }
        if(start != null){
            example.setRetailPriceMin(start);
        }
        if(end != null){
            example.setRetailPriceMax(end);
            if (start == null){
                example.setRetailPriceMin(BigDecimal.ZERO);
            }
        }
        List<TMdseInfo> list = mdseInfoMapper.selectMdseInfoAndMdsePrice(example);
        PageInfo<TMdseInfo> pageInfo = new PageInfo<TMdseInfo>(list);
        return pageInfo;
    }
}

package com.service.impl.mdse;
import com.dao.mdse.MdseSalesMapper;
import com.entity.po.Example.mdse.TMdseSalesExample;
import com.entity.po.mdse.TMdseSales;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.service.mdse.IMdseSalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service("mdseSalesService")
public class MdseSalesServiceImpl implements IMdseSalesService {
    static Logger LOGGER = LoggerFactory.getLogger(MdseSalesServiceImpl.class);
    @Autowired
    MdseSalesMapper mdseSalesMapper;
    
    @Override
    public List<TMdseSales> findMdseSales(TMdseSales t) throws Exception {
        return mdseSalesMapper.select(t);
    }

    @Override
    public Integer countMdseSales(TMdseSales t) throws Exception {
        return mdseSalesMapper.selectCount(t);
    }

    @Override
    public TMdseSales findMdseSalesById(Long id) throws Exception {
        return mdseSalesMapper.selectByPrimaryKey(id);
    }

    @Override
    public TMdseSales findMdseSalesByMdseNo(String mdseNo) throws Exception {
        TMdseSales mdseSales = new TMdseSales();
        mdseSales.setMdseNo(mdseNo);
        return mdseSalesMapper.selectOne(mdseSales);
    }

    @Override
    public Integer addMdseSales(TMdseSales t) throws Exception {
        return mdseSalesMapper.insert(t);
    }

    @Override
    public Integer updateMdseSales(TMdseSales t) throws Exception {
        return mdseSalesMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public Integer deleteMdseSales(Long id) throws Exception {
        return mdseSalesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<TMdseSales> findMdseSales(TMdseSales t, int pageNum, int pageSize, String ordername, String order) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        ordername = StringUtil.isNotEmpty(ordername)?ordername:"id";
        order = StringUtil.isNotEmpty(order)?order:"desc";
        TMdseSalesExample example = new TMdseSalesExample();
        example.setOrderByClause(ordername+" "+order);
        TMdseSalesExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(t.getMdseNo())){
            if(t.getMdseNo().indexOf("&")>0){
                String [] str = t.getMdseNo().split("&");
                List<String> list = Arrays.asList(str);
                criteria.andMdsenoIn(list);
            }else {
                criteria.andMdsenoLike("%"+t.getMdseNo()+"%");
            }

        }
        if(StringUtil.isNotEmpty(t.getSalesChannel())){
            criteria.andSaleschannelEqualTo(t.getSalesChannel());
        }
        if(StringUtil.isNotEmpty(t.getPlatformId())){
            criteria.andPlatformidEqualTo(t.getPlatformId());
        }
        if(StringUtil.isNotEmpty(t.getSalesStatus())){
            criteria.andSalesstatusEqualTo(t.getSalesStatus());
        }
        if(StringUtil.isNotEmpty(t.getPreferentialType())){
            criteria.andPreferentialtypeEqualTo(t.getPreferentialType());

        }
        List<TMdseSales> list = mdseSalesMapper.selectMdseSalesAndMdseInfo(example);
        PageInfo<TMdseSales> pageSales = new PageInfo<TMdseSales>(list);
        return pageSales;
    }
}

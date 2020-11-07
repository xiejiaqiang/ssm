package com.service.impl.mdse;

import com.dao.mdse.MdseRegionMapper;
import com.entity.po.mdse.TMdseRegion;
import com.service.mdse.IMdseRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MdseRegionService")
public class MdseRegionServiceImpl implements IMdseRegionService {
    static Logger LOGGER = LoggerFactory.getLogger(MdseRegionServiceImpl.class);
    @Autowired
    MdseRegionMapper MdseRegionMapper;
    
    @Override
    public List<TMdseRegion> findMdseRegion(TMdseRegion t) throws Exception {
        return MdseRegionMapper.select(t);
    }

    @Override
    public Integer countMdseRegion(TMdseRegion t) throws Exception {
        return MdseRegionMapper.selectCount(t);
    }

    @Override
    public TMdseRegion findMdseRegionById(Long id) throws Exception {
        return MdseRegionMapper.selectByPrimaryKey(id);
    }

    @Override
    public TMdseRegion findMdseRegionByMdseNo(String mdseNo) throws Exception {
        TMdseRegion MdseRegion = new TMdseRegion();
        MdseRegion.setMdseNo(mdseNo);
        return MdseRegionMapper.selectOne(MdseRegion);
    }

    @Override
    public List<TMdseRegion> findMdseRegionByMdseCat(List<String> mdseCat) throws Exception {
        return MdseRegionMapper.selectMdseRegionInfo(mdseCat);
    }

    @Override
    public List<TMdseRegion> findMdseRegionGroupMdseNo(String mdseCat) throws Exception {

        return MdseRegionMapper.findMdseRegionGroupMdseNo(mdseCat);
    }

    @Override
    public List<TMdseRegion> findMdseRegionByMdseNoGroup(String mdseCat) throws Exception {
        return MdseRegionMapper.selectMdseRegionByMdseNoGroup(mdseCat);
    }

    @Override
    public Integer addMdseRegion(TMdseRegion t) throws Exception {
        return MdseRegionMapper.insert(t);
    }

    @Override
    public Integer updateMdseRegion(TMdseRegion t) throws Exception {
        return MdseRegionMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public Integer deleteMdseRegion(Long id) throws Exception {
        return MdseRegionMapper.deleteByPrimaryKey(id);
    }
}

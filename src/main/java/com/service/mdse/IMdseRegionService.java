package com.service.mdse;
import com.entity.po.mdse.TMdseRegion;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 商品信息
 */
public interface IMdseRegionService {
	// 查询所有
	public List<TMdseRegion> findMdseRegion(TMdseRegion t) throws Exception;

	// 数量
	public Integer countMdseRegion(TMdseRegion t) throws Exception;

	// 通过ID查询
	public TMdseRegion findMdseRegionById(Long id) throws Exception;

	// 通过mdseNo查询
	public TMdseRegion findMdseRegionByMdseNo(String mdseNo) throws Exception;

	// 统计
	public List<TMdseRegion> findMdseRegionByMdseCat(List<String> mdseCat) throws Exception;

	// 统计
	public List<TMdseRegion> findMdseRegionGroupMdseNo(String mdseCat) throws Exception;

	// 统计
	public List<TMdseRegion> findMdseRegionByMdseNoGroup(String mdseCat) throws Exception;


	// 新增
	public Integer addMdseRegion(TMdseRegion t) throws Exception;

	// 修改
	public Integer updateMdseRegion(TMdseRegion t) throws Exception;

	// 删除
	public Integer deleteMdseRegion(Long id) throws Exception;

}

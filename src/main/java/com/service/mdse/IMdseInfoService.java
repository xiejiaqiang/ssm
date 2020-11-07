package com.service.mdse;

import com.entity.po.mdse.TMdseInfo;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品信息
 */
public interface IMdseInfoService {
	// 查询所有
	public List<TMdseInfo> findMdseInfo(TMdseInfo t) throws Exception;

	// 数量
	public Integer countMdseInfo(TMdseInfo t) throws Exception;

	// 通过ID查询
	public TMdseInfo findMdseInfoById(Long id) throws Exception;

	// 通过mdseNo查询
	public TMdseInfo findMdseInfoByMdseNo(String mdseNo) throws Exception;

	// 新增
	public Integer addMdseInfo(TMdseInfo t) throws Exception;

	// 修改
	public Integer updateMdseInfo(TMdseInfo t) throws Exception;

	// 删除
	public Integer deleteMdseInfo(Long id) throws Exception;

	public PageInfo<TMdseInfo> findMdseInfo(TMdseInfo t, int pageNum, int pageSize, String ordername, String order, BigDecimal start, BigDecimal end,List<String> mdseCats) throws Exception;

}

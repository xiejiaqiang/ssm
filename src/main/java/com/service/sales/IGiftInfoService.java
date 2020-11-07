package com.service.sales;
import com.entity.po.sales.TGiftInfo;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface IGiftInfoService {
	// 查询所有
	public List<TGiftInfo> findGiftInfo(TGiftInfo t) throws Exception;

	// 数量
	public Integer countGiftInfo(TGiftInfo t) throws Exception;

	// 通过ID查询
	public TGiftInfo findGiftInfoById(Long id) throws Exception;

	// 通过GiftNo查询
	public TGiftInfo findGiftInfoByGiftNo(String GiftNo) throws Exception;

	// 新增
	public Integer addGiftInfo(TGiftInfo t) throws Exception;

	// 修改
	public Integer updateGiftInfo(TGiftInfo t) throws Exception;

	// 删除
	public Integer deleteGiftInfo(Long id) throws Exception;

	public PageInfo<TGiftInfo> findGiftInfo(TGiftInfo t, int pageNum, int pageSize, String ordername, String order) throws Exception;

}

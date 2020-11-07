package com.service.mdse;
import com.entity.po.mdse.TMdseSales;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品信息
 */
public interface IMdseSalesService {
	// 查询所有
	public List<TMdseSales> findMdseSales(TMdseSales t) throws Exception;

	// 数量
	public Integer countMdseSales(TMdseSales t) throws Exception;

	// 通过ID查询
	public TMdseSales findMdseSalesById(Long id) throws Exception;

	// 通过mdseNo查询
	public TMdseSales findMdseSalesByMdseNo(String mdseNo) throws Exception;

	// 新增
	public Integer addMdseSales(TMdseSales t) throws Exception;

	// 修改
	public Integer updateMdseSales(TMdseSales t) throws Exception;

	// 删除
	public Integer deleteMdseSales(Long id) throws Exception;

	public PageInfo<TMdseSales> findMdseSales(TMdseSales t, int pageNum, int pageSize, String ordername, String order) throws Exception;

}

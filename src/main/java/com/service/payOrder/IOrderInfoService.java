package com.service.payOrder;

import com.entity.po.payOrder.TOrderInfo;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 支付订单
 */
public interface IOrderInfoService {
	// 查询所有
	public List<TOrderInfo> findOrderInfo(TOrderInfo t) throws Exception;

	// 数量
	public int countOrderInfo(TOrderInfo t) throws Exception;

	// 通过ID查询
	public TOrderInfo findOrderInfoById(Integer id) throws Exception;

	// 新增
	public Integer addOrderInfo(TOrderInfo t) throws Exception;

	// 批量新增
	public BathInsertResultVO bathAddOrderInfo(MultipartFile file) throws Exception;

	// 修改
	public Integer updateOrderInfo(TOrderInfo t) throws Exception;

	// 删除
	public Integer deleteOrderInfo(Integer id) throws Exception;

	public PageInfo<TOrderInfo> findOrderInfoPage(TOrderInfo t, int pageNum, int pageSize, String ordername, String order, String start, String end) throws Exception;


}

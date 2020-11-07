package com.service.order;

import com.entity.po.order.TOrderInfo;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
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
	public Integer deleteOrderInfo(Long id) throws Exception;

	public PageInfo<TOrderInfo> findOrderInfoPage(TOrderInfo t, int pageNum, int pageSize, String ordername, String order, String start, String end) throws Exception;

	// 查询总条数
	public Integer orderInfoCount() throws Exception;

	// 查询总金额
	public BigDecimal orderInfoCountAmount() throws Exception;

	// 按日期查询订单
	public List<TOrderInfo> orderListByGroupDate(String start, String end) throws Exception;

	// 按日期查询订单
	public List<TOrderInfo> orderListByDate(String start, String end) throws Exception;


	// 查询最新交易的n条数据
	public List<TOrderInfo> orderInfo(int size) throws Exception;
}

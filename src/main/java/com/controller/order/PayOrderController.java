package com.controller.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.config.util.ConfigUtil;
import com.controller.systemManage.LogController;
import com.entity.po.mdse.TMdseInfo;
import com.entity.po.order.TOrderInfo;
import com.entity.po.systemManage.Operation;
import com.entity.vo.AddressInfo;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageInfo;
import com.service.impl.systemManage.OperationServiceImpl;
import com.service.mdse.IMdseInfoService;
import com.service.order.IOrderInfoService;
import com.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("orderInfo")
public class PayOrderController extends LogController {
	static Logger LOGGER = LoggerFactory.getLogger(PayOrderController.class);

	@Autowired
	private IOrderInfoService orderInfoService;
	@Autowired
	private OperationServiceImpl operationService;
	@Autowired
	private IMdseInfoService mdseInfoService;

	@RequestMapping("orderInfoIndex")
	public String index(HttpServletRequest request, Integer menuid) throws Exception {
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		return "order/orderInfo";
	}
	@RequestMapping(value="orderInfoList",method= RequestMethod.POST)
	public void userList(HttpServletRequest request, HttpServletResponse response, TOrderInfo orderInfo, String offset, String limit) throws Exception{
		try {
			String end = request.getParameter("end");
			String start = request.getParameter("start");
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			Integer pageSize = StringUtil.isEmpty(limit)? ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<TOrderInfo> orderInfoList= orderInfoService.findOrderInfoPage(orderInfo,pageNum,pageSize,ordername,order, start, end);
			request.setAttribute("start", start);
			request.setAttribute("end", end);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",orderInfoList.getTotal() );
			jsonObj.put("rows", orderInfoList.getList());
			WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("支付订单展示错误",e);
			throw e;
		}
	}

	@RequestMapping("batchImport")
	@ResponseBody
	public JSONObject batchImport(@RequestParam MultipartFile[] txt_file,String type, HttpSession session ,HttpServletResponse response) throws Exception {
		BathInsertResultVO res = new BathInsertResultVO();
		JSONObject result = new JSONObject();
		try {
			LOGGER.info("batchImport 批量新增支付订单信息");
			res = orderInfoService.bathAddOrderInfo(txt_file[0],type);
			LOGGER.info("batchImport 批量新增支付订单信息完成，新增结果:[{}]", JSON.toJSON(res));
			result.put("success", true);
		} catch (Exception e) {
			LOGGER.error("batchImport 批量新增支付订单信息失败，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "数据库操作失败");
			result.put("success", false);
			return result;
		}
		if (res.getCountSize() == res.getSuccessSize()) {
			LOGGER.info("batchImport 批量新增支付订单信息全部成功！");
			return result;
		} else {
			LOGGER.info("batchImport 批量新增支付订单信息部分成功,成功条数[],总条数", res.getSuccessSize(), res.getCountSize());
			result.put("msg", "成功条数" + res.getSuccessSize() + ",失败条数" + res.getFailSize() + ",总条数" + res.getCountSize() + "");
			result.put("data", res.getFailInfoVoList());
			return result;
		}
	}

	@RequestMapping("batchImportLstcs")
	@ResponseBody
	public JSONObject batchImportLstcs(@RequestParam MultipartFile[] txt_file_lstcs, HttpSession session ,HttpServletResponse response) throws Exception {
		BathInsertResultVO res = new BathInsertResultVO();
		JSONObject result = new JSONObject();
		try {
			LOGGER.info("batchImportLstcs 批量新增物流信息");
			res = orderInfoService.bathUptLstcs(txt_file_lstcs[0]);
			LOGGER.info("batchImportLstcs 批量新增物流信息完成，新增结果:[{}]", JSON.toJSON(res));
			result.put("success", true);
		} catch (Exception e) {
			LOGGER.error("batchImportLstcs 批量新增物流信息失败，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "数据库操作失败");
			result.put("success", false);
			return result;
		}
		if (res.getCountSize() == res.getSuccessSize()) {
			LOGGER.info("batchImportLstcs 批量新增物流信息全部成功！");
			return result;
		} else {
			LOGGER.info("batchImportLstcs 批量新增物流信息部分成功,成功条数[],总条数", res.getSuccessSize(), res.getCountSize());
			result.put("msg", "成功条数" + res.getSuccessSize() + ",失败条数" + res.getFailSize() + ",总条数" + res.getCountSize() + "");
			result.put("data", res.getFailInfoVoList());
			return result;
		}
	}


	// 新增或修改
	@RequestMapping("reserveOrderInfo")
	public void reserveOrderInfo(HttpServletRequest request, TOrderInfo orderInfo,String editOrderDate, HttpServletResponse response){
		Long id = orderInfo.getId();
		JSONObject result=new JSONObject();
		try {
			Date orderDate = DateUtil.ParseTime(editOrderDate, "yyyy-MM-dd");
			orderInfo.setOrderDate(orderDate);
		} catch (ParseException e) {
			LOGGER.error("日期转换失败[{}]", editOrderDate);
		}
		try {
			if (id != null) {   // Id不为空 说明是修改
				//是否新增销售区域信息
				boolean isUptRegion =false;
				//根据id查询老数据
				TOrderInfo orderInfo1 = orderInfoService.findOrderInfoById(id);
				//原地址等于空或等于“待更新”并且新地址不为空
				if((StringUtils.isEmpty(orderInfo1.getAddress())||"待更新".equals(orderInfo1.getAddress()))&&!StringUtils.isEmpty(orderInfo.getAddress())){
					isUptRegion = true;
				}
				int status = orderInfoService.updateOrderInfo(orderInfo, isUptRegion);
					result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，更新失败");
				}
			}else {
				int status =orderInfoService.addOrderInfo(orderInfo);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，新增失败");
				}
			}
		} catch (Exception e) {
			if(e instanceof DuplicateKeyException){
				LOGGER.error("新增失败，该订单已存在{}", JSON.toJSONString(e));
				result.put("errorMsg", "新增失败!该订单已存在");
			}else {
				LOGGER.error("保存支付订单信息错误{}",e);
				result.put("errorMsg", "对不起，操作失败");
			}
			result.put("success", false);
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping("deleteOrderInfo")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				orderInfoService.deleteOrderInfo(Long.valueOf(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			LOGGER.error("删除用户信息错误[{}]",JSON.toJSONString(e));
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping(value="export",method= RequestMethod.GET)
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception{
		TOrderInfo orderInfo = new TOrderInfo();
		String end = request.getParameter("end");
		String start = request.getParameter("start");
		String orderNo = request.getParameter("txt_orderNo");
		String custName = request.getParameter("txt_custName");
		String numberNo = request.getParameter("txt_numberNo");
		String orderStatus = request.getParameter("txt_search_orderStatus");
		String orderChannel = request.getParameter("txt_search_orderChannel");
		orderInfo.setOrderNo(orderNo);
		orderInfo.setCustName(custName);
		orderInfo.setNumberNo(numberNo);
		orderInfo.setOrderStatus(orderStatus);
		orderInfo.setOrderChannel(orderChannel);
		Integer pageSize = 9999999;
		Integer pageNum =  1;
		PageInfo<TOrderInfo> orderInfoList= orderInfoService.findOrderInfoPage(orderInfo,pageNum,pageSize,null,null, start, end);
		List<TOrderInfo> orderInfos = new ArrayList<TOrderInfo>();
		orderInfos = CopyUtils.copyList(orderInfoList.getList(), TOrderInfo.class);
		String [] str = new String[]{"主键","订单编号","商品编号","商品名称","客户姓名",
				"手机号","收货地址","订单金额","实付金额","优惠分类","订单状态","物流单号",
				"开票说明","开票类型","订单日期","订单数量","进货价格","进货来源","订单渠道","备注"};
		ExcelUtils.exportExcel("支付订单信息_"+DateUtil.getChar8()+".xls",str,orderInfos,response,"yyyy-MM-dd");
	}


	@RequestMapping("findMdseNo")
	public void findMdseNo(String mdseNo, HttpServletRequest request, HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			TMdseInfo mdseInfo = mdseInfoService.findMdseInfoByMdseNo(mdseNo);
			if(mdseInfo == null){
				result.put("success", false);
			}else {
				result.put("success", true);
			}
		} catch (Exception e) {
			LOGGER.error("查询商品信息失败[{}]",JSON.toJSONString(e));
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping("findOrderIndex")
	public void findOrderIndex(int queryListType, HttpServletRequest request, HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			//查询近一个月订单数做统计;
			List<TOrderInfo> list = new ArrayList<TOrderInfo>();
			String date = "";
			if(queryListType ==1){
				date = DateUtil.getBeforeDate1();

			}else if (queryListType ==2){
				date = DateUtil.getBeforeMonth1();
			}else if(queryListType ==3){
				date = DateUtil.getBeforeYear1();
			}

			list = orderInfoService.orderListByGroupDate(date,DateUtil.getChar82());
			BigDecimal maxAmount = new BigDecimal(BigInteger.ZERO);
			for (TOrderInfo orderInfo: list) {
				if(maxAmount.compareTo(orderInfo.getOrderAmount()) ==-1){
					maxAmount = orderInfo.getOrderAmount();
				}
			}
			List<TOrderInfo> list2 = new ArrayList<TOrderInfo>();
			//2个月前订单
			list2 = orderInfoService.orderListByDate(DateUtil.getBeforeMonth2(),DateUtil.getBeforeMonth1());
			double acountOrderSize2 = list2.size();
			//2个月前销售额
			BigDecimal acountOrderMonth1Amount2 = new BigDecimal(BigInteger.ZERO);
			for (TOrderInfo orderInfo: list2) {
				acountOrderMonth1Amount2 = acountOrderMonth1Amount2.add(orderInfo.getOrderAmount());

			}
			//最近一月订单
			List<TOrderInfo> list3 = new ArrayList<TOrderInfo>();
			list3 = orderInfoService.orderListByDate(DateUtil.getBeforeMonth1(),DateUtil.getChar82());

			double acountOrderSize = list3.size();
			//最近一月销售额
			BigDecimal acountOrderMonth1Amount = new BigDecimal(BigInteger.ZERO);
			for (TOrderInfo orderInfo: list3) {
				BigDecimal c = orderInfo.getOrderAmount();
				acountOrderMonth1Amount = acountOrderMonth1Amount.add(orderInfo.getOrderAmount());

			}
			//订单增长率
			String orderIncreaseValue ="";
			int orderIncreaseNo =0;
			Double crease = ((acountOrderSize-acountOrderSize2)/acountOrderSize2)*100;
			if(crease>0){
				orderIncreaseValue = "fa-level-up";
			}else if (crease ==0){
				orderIncreaseValue = "fa-bolt";
			}else {
				orderIncreaseValue = "fa-level-down";
			}
			orderIncreaseNo = crease.intValue();

			//销售额增长率
			String orderAmountValue ="";
			BigDecimal amountZzl = acountOrderMonth1Amount.subtract(acountOrderMonth1Amount2).divide(acountOrderMonth1Amount, BigDecimal.ROUND_DOWN).multiply(new BigDecimal(100));
			if(amountZzl.compareTo(BigDecimal.ZERO) == -1){
				orderAmountValue = "fa-level-down";
			}else if (amountZzl.compareTo(BigDecimal.ZERO) ==0){
				orderAmountValue = "fa-bolt";
			}else {
				orderAmountValue = "fa-level-up";
			}
			//存入
			result.put("acountOrderSize", acountOrderSize);
			result.put("acountOrderMonth1Amount", acountOrderMonth1Amount);
			result.put("orderAmountNo", amountZzl);
			result.put("orderAmountValue", orderAmountValue);
			result.put("orderIncreaseNo", orderIncreaseNo);
			result.put("orderIncreaseValue", orderIncreaseValue);
			result.put("countOrder", orderInfoService.orderInfoCount());

			result.put("maxAmount", maxAmount);
			BigInteger c = maxAmount.toBigInteger();
			String str = c.toString().substring(0,1);
			String str1 = new BigDecimal(str).add(BigDecimal.ONE).toString();
			String str2 = maxAmount.toString().substring(1,maxAmount.toString().length());
			String str3 = str1+str2;
			BigDecimal str4 = new BigDecimal(str3);
			result.put("str4", str4);
			result.put("data", list);
			result.put("acountOrderMonth1Amount", acountOrderMonth1Amount);
			result.put("acountOrderMonth1Size", acountOrderSize);
			result.put("acountOrderSize", acountOrderSize);
		} catch (Exception e) {
			LOGGER.error("查询订单信息失败[{}]",JSON.toJSONString(e));
		}
		WriterUtil.write(response, result.toString());
	}



	@RequestMapping("findOrderGroupMdseNo")
	public void findOrderGroupMdseNo(HttpServletRequest request, HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			List<TOrderInfo> list = orderInfoService.selectOrderInfoGroupMdseNo();
			result.put("data", list);
			result.put("success", true);
		} catch (Exception e) {
			LOGGER.error("查询订单信息失败[{}]",JSON.toJSONString(e));
			result.put("success", false);
			result.put("errorMsg", "对不起，查询失败");
		}
		WriterUtil.write(response, result.toString());
	}

}

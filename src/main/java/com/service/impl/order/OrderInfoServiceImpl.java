package com.service.impl.order;

import com.alibaba.fastjson.JSON;
import com.controller.payOrder.PayOrderController;
import com.dao.order.OrderInfoMapper;
import com.entity.po.Example.payOrder.TOrderInfoExample;
import com.entity.po.payOrder.TOrderInfo;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.service.payOrder.IOrderInfoService;
import com.util.DateUtil;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("orderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService {
	static Logger LOGGER = LoggerFactory.getLogger(OrderInfoServiceImpl.class);

	@Autowired
	OrderInfoMapper orderInfoMapper;

	// 查询所有
	public List<TOrderInfo> findOrderInfo(TOrderInfo t) throws Exception {
		return orderInfoMapper.select(t);
	};

	// 数量
	public int countOrderInfo(TOrderInfo t) throws Exception {
		return orderInfoMapper.selectCount(t);
	};

	// 通过ID查询
	public TOrderInfo findOrderInfoById(Integer id) throws Exception {
		return orderInfoMapper.selectByPrimaryKey(id);
	};

	// 新增
	public Integer addOrderInfo(TOrderInfo t) throws Exception {
		return orderInfoMapper.insert(t);
	}

	@Override
	public BathInsertResultVO bathAddOrderInfo(MultipartFile file) throws Exception {
		int result = 0;
		//存放excel表中所有user数据
		List<TOrderInfo> orderInfoList = new ArrayList<TOrderInfo>();

		//file.getOriginalFilename()方法 得到上传时的文件名
		String fileName = file.getOriginalFilename();
		//截取文件名的后缀
		String suffix = fileName.substring(fileName.lastIndexOf(".")+1);

		//file.getInputStream()方法  返回InputStream对象 读取文件的内容
		InputStream ins = file.getInputStream();
		XSSFWorkbook xssfWb = null;
		HSSFWorkbook hssfWb = null;
		XSSFSheet xssfs = null;
		HSSFSheet hssfs = null;
        /*判断文件后缀
            XSSF － 提供读写Microsoft Excel OOXML XLSX格式档案的功能。
            HSSF － 提供读写Microsoft Excel XLS格式档案的功能。*/
		if(suffix.equals("xlsx")){
			xssfWb = new XSSFWorkbook(ins);
			//获取excel表单的sheet对象
			xssfs = xssfWb.getSheetAt(0);
			//如果sheet不为空，就开始遍历表中的数据
			if(null != xssfs){
				//line = 1 :从表的第二行开始获取记录
				for(int line = 1; line <= xssfs.getLastRowNum();line++){

					//excel表单的sheet的行对象
					XSSFRow row = xssfs.getRow(line);
					//如果某行为空，跳出本行
					if(null == row){
						continue;
					}
					TOrderInfo orderInfo = setOrderInfoXSSFRow(row);
					orderInfoList.add(orderInfo);

				}
			}
		}else{
			hssfWb = new HSSFWorkbook(ins);
			//获取excel表单的sheet对象
			hssfs = hssfWb.getSheetAt(0);;
			//如果sheet不为空，就开始遍历表中的数据
			if(null != hssfs){
				//line = 1 :从表的第二行开始获取记录
				for(int line = 1; line <= hssfs.getLastRowNum();line++){
					//excel表单的sheet的行对象
					HSSFRow row = hssfs.getRow(line);
					//如果某行为空，跳出本行
					if(null == row){
						continue;
					}
					TOrderInfo orderInfo = setOrderInfoHSSF(row);
					orderInfoList.add(orderInfo);
				}
			}
		}
		BathInsertResultVO resultVO = new BathInsertResultVO();
		List<BathInsertResultVO.FailInfoVo> failInfoVoList = new ArrayList<BathInsertResultVO.FailInfoVo>();
		int countSize = orderInfoList.size();
		int successSize = 0;
		int failSize =0;
		for (int i=0; i<orderInfoList.size();i++){
			try {
				addOrderInfo(orderInfoList.get(i));
				successSize = successSize +1;
			}catch (Exception e){
				LOGGER.error("新增失败", JSON.toJSONString(e));
				failSize = failSize+1;
				BathInsertResultVO.FailInfoVo failInfoVo = new BathInsertResultVO.FailInfoVo();
				failInfoVo.setFailMsg("数据库操作失败");
				failInfoVo.setOrderNo(orderInfoList.get(i).getOrderNo());
				failInfoVoList.add(failInfoVo);
			}
		}
		resultVO.setCountSize(countSize);
		resultVO.setFailSize(failSize);
		resultVO.setSuccessSize(successSize);
		resultVO.setFailInfoVoList(failInfoVoList);
		return resultVO;
	};

	private  TOrderInfo setOrderInfoXSSFRow(XSSFRow row){

		row.getCell(0).setCellType(CellType.STRING);
		String orderNo = row.getCell(0).getStringCellValue();

		row.getCell(1).setCellType(CellType.STRING);
		String mdseNo = row.getCell(1).getStringCellValue();
		row.getCell(2).setCellType(CellType.STRING);
		String custName = row.getCell(2).getStringCellValue();
		row.getCell(3).setCellType(CellType.STRING);
		String numberNo = row.getCell(3).getStringCellValue();
		row.getCell(4).setCellType(CellType.STRING);
		String address = row.getCell(4).getStringCellValue();
		row.getCell(5).setCellType(CellType.STRING);
		BigDecimal orderAmount = new BigDecimal(row.getCell(5).getStringCellValue());
		row.getCell(6).setCellType(CellType.STRING);
		BigDecimal actPayAmount = new BigDecimal(row.getCell(6).getStringCellValue());
		row.getCell(7).setCellType(CellType.STRING);
		String discountType = row.getCell(7).getStringCellValue();
		row.getCell(8).setCellType(CellType.STRING);
		String orderStatus = row.getCell(8).getStringCellValue();
		row.getCell(9).setCellType(CellType.STRING);
		String logisticsNo = row.getCell(9).getStringCellValue();
		row.getCell(10).setCellType(CellType.STRING);
		String invoiceFlg = row.getCell(10).getStringCellValue();
		row.getCell(11).setCellType(CellType.STRING);
		String invoiceType = row.getCell(11).getStringCellValue();
		Date orderDate = null;
		String date = getDateValueXSSF(row.getCell(12).getCellType(), row.getCell(12));
		try {
			orderDate = DateUtil.ParseTime(date,"yyyy-mm-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		row.getCell(13).setCellType(CellType.STRING);
		String orderChannel = row.getCell(13).getStringCellValue();
		row.getCell(14).setCellType(CellType.STRING);
		String remarks = row.getCell(14).getStringCellValue();
		TOrderInfo orderInfo = new TOrderInfo();
		orderInfo.setRemarks(remarks);
		orderInfo.setOrderStatus(orderStatus);
		orderInfo.setOrderNo(orderNo);
		orderInfo.setOrderDate(orderDate);
		orderInfo.setOrderChannel(orderChannel);
		orderInfo.setOrderAmount(orderAmount);
		orderInfo.setNumberNo(numberNo);
		orderInfo.setMdseNo(mdseNo);
		orderInfo.setLogisticsNo(logisticsNo);
		orderInfo.setInvoiceType(invoiceType);
		orderInfo.setInvoiceFlg(invoiceFlg);
		orderInfo.setCustName(custName);
		orderInfo.setDiscountType(discountType);
		orderInfo.setAddress(address);
		orderInfo.setActPayAmount(actPayAmount);
		orderInfo.setMdseName(mdseNo);
		return orderInfo;
	};
	private  TOrderInfo setOrderInfoHSSF(HSSFRow row){

		row.getCell(0).setCellType(CellType.STRING);
		String orderNo = row.getCell(0).getStringCellValue();

		row.getCell(1).setCellType(CellType.STRING);
		String mdseNo = row.getCell(1).getStringCellValue();
		row.getCell(2).setCellType(CellType.STRING);
		String custName = row.getCell(2).getStringCellValue();
		row.getCell(3).setCellType(CellType.STRING);
		String numberNo = row.getCell(3).getStringCellValue();
		row.getCell(4).setCellType(CellType.STRING);
		String address = row.getCell(4).getStringCellValue();
		row.getCell(5).setCellType(CellType.NUMERIC);
		BigDecimal orderAmount = new BigDecimal(row.getCell(5).getNumericCellValue());
		row.getCell(6).setCellType(CellType.NUMERIC);
		BigDecimal actPayAmount = new BigDecimal(row.getCell(6).getNumericCellValue());
		row.getCell(7).setCellType(CellType.STRING);
		String discountType = row.getCell(7).getStringCellValue();
		row.getCell(8).setCellType(CellType.STRING);
		String orderStatus = row.getCell(8).getStringCellValue();
		row.getCell(9).setCellType(CellType.STRING);
		String logisticsNo = row.getCell(9).getStringCellValue();
		row.getCell(10).setCellType(CellType.STRING);
		String invoiceFlg = row.getCell(10).getStringCellValue();
		row.getCell(11).setCellType(CellType.STRING);
		String invoiceType = row.getCell(11).getStringCellValue();
		String date = getDateValueHSSF(row.getCell(12).getCellType(), row.getCell(12));
		Date orderDate = null;
		try {
			orderDate = DateUtil.ParseTime(date,"yyyy-mm-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		row.getCell(13).setCellType(CellType.STRING);
		String orderChannel = row.getCell(13).getStringCellValue();
		row.getCell(14).setCellType(CellType.STRING);
		String remarks = row.getCell(14).getStringCellValue();
		TOrderInfo orderInfo = new TOrderInfo();
		orderInfo.setRemarks(remarks);
		orderInfo.setOrderStatus(orderStatus);
		orderInfo.setOrderNo(orderNo);
		orderInfo.setOrderDate(orderDate);
		orderInfo.setOrderChannel(orderChannel);
		orderInfo.setOrderAmount(orderAmount);
		orderInfo.setNumberNo(numberNo);
		orderInfo.setMdseNo(mdseNo);
		orderInfo.setLogisticsNo(logisticsNo);
		orderInfo.setInvoiceType(invoiceType);
		orderInfo.setInvoiceFlg(invoiceFlg);
		orderInfo.setCustName(custName);
		orderInfo.setDiscountType(discountType);
		orderInfo.setAddress(address);
		orderInfo.setActPayAmount(actPayAmount);
		orderInfo.setMdseName(mdseNo);
		return orderInfo;
	};
	private static String getDateValueHSSF(CellType cellType, HSSFCell value) {
		if (cellType == CellType.BOOLEAN) {
			return String.valueOf(value.getBooleanCellValue());
		} else if (cellType == CellType.NUMERIC) {
			//20180622,支持日期格式
			if(HSSFDateUtil.isCellDateFormatted(value)){
				Date d = (Date) value.getDateCellValue();
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//HH:mm:ss
				return df2.format(d);
			}
//数字
			else{
				//使用DecimalFormat对double进行了格式化，随后使用format方法获得的String就是你想要的值了。
				DecimalFormat df = new DecimalFormat("0");
				return String.valueOf(df.format(value.getNumericCellValue()));
			}

		} else {
			return String.valueOf(value.getStringCellValue());
		}
	}
	private static String getDateValueXSSF(CellType cellType, XSSFCell value) {
		if (cellType == CellType.BOOLEAN) {
			return String.valueOf(value.getBooleanCellValue());
		} else if (cellType == CellType.NUMERIC) {
			//20180622,支持日期格式
			if(HSSFDateUtil.isCellDateFormatted(value)){
				Date d = (Date) value.getDateCellValue();
				DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//HH:mm:ss
				return df2.format(d);
			}
//数字
			else{
				//使用DecimalFormat对double进行了格式化，随后使用format方法获得的String就是你想要的值了。
				DecimalFormat df = new DecimalFormat("0");
				return String.valueOf(df.format(value.getNumericCellValue()));
			}

		} else {
			return String.valueOf(value.getStringCellValue());
		}
	}

	// 修改
	public Integer updateOrderInfo(TOrderInfo t) throws Exception {
		return orderInfoMapper.updateByPrimaryKeySelective(t);
	};

	// 删除
	public Integer deleteOrderInfo(Integer id) throws Exception {
		return orderInfoMapper.deleteByPrimaryKey(id);
	}

	public PageInfo<TOrderInfo> findOrderInfoPage(TOrderInfo t, int pageNum, int pageSize, String ordername, String order, String start, String end) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"id";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		TOrderInfoExample example = new TOrderInfoExample();
		example.setOrderByClause(ordername+" "+order);
		TOrderInfoExample.Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(t.getCustName())){
			criteria.andCustnameLike("%"+t.getCustName()+"%");
		}
		if(StringUtil.isNotEmpty(t.getOrderNo())){
			criteria.andOrdernoEqualTo(t.getOrderNo());
		}
		if(StringUtil.isNotEmpty(t.getNumberNo())){
			criteria.andNumbernoEqualTo(t.getNumberNo());
		}
		if(StringUtil.isNotEmpty(t.getOrderStatus())){
			criteria.andOrderstatusEqualTo(t.getOrderStatus());
		}
		if(StringUtil.isNotEmpty(t.getOrderChannel())){
			criteria.andOrderchannelEqualTo(t.getOrderChannel());
		}
		Calendar cal = Calendar.getInstance();
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("1900-01-01");
		cal.setTime(startDate);
		Date startTime = cal.getTime();
		Date endTime = new Date();
		if(com.util.StringUtil.isNotEmpty(start)){
			startTime = DateUtil.ParseTime(start, "yyyy-MM-dd");
		}
		if(com.util.StringUtil.isNotEmpty(end)){
			endTime = DateUtil.ParseTime(end, "yyyy-MM-dd");
		}
		criteria.andOrderdateBetween(startTime, endTime);
		List<TOrderInfo> list = orderInfoMapper.selectOrderInfoAndMdseInfo(example);
		PageInfo<TOrderInfo> pageInfo = new PageInfo<TOrderInfo>(list);
		return pageInfo;
	}

	;




}

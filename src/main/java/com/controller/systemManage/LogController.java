package com.controller.systemManage;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.po.systemManage.Attachment;
import com.entity.po.systemManage.Log;
import com.entity.po.systemManage.Operation;
import com.util.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.config.util.ConfigUtil;
import com.service.impl.systemManage.AttachmentServiceImpl;
import com.service.impl.systemManage.LogServiceImpl;
import com.service.impl.systemManage.OperationServiceImpl;
import com.util.PropertiesUtil;
import com.util.StringUtil;
import com.util.WriterUtil;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("log")
public class LogController{

	static Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@Autowired
	private LogServiceImpl logService;
	@Autowired
	private AttachmentServiceImpl attachmentService;
	@Autowired
	private OperationServiceImpl operationService;
	
	
	@RequestMapping("logIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		return "systemManage/log";
	}
	
	
	@RequestMapping("logList")
	public void logList(HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			Log log = new Log();
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			String module = request.getParameter("module");
			String operation = request.getParameter("operation");
			String username = request.getParameter("username");
			log.setModule(module);
			log.setOperation(operation);
			log.setUsername(username);
			String end = request.getParameter("end");
			String start = request.getParameter("start");
			Integer pageSize = StringUtil.isEmpty(limit)?ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<Log> pageInfo = logService.pageLogCreateBetween(start,end, log,pageNum,pageSize,ordername,order);
			request.setAttribute("module", module);
			request.setAttribute("operation", operation);
			request.setAttribute("username", username);
			request.setAttribute("start", start);
			request.setAttribute("end", end);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",pageInfo.getTotal());
			jsonObj.put("rows", pageInfo.getList());
	        WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	/**
	 * 批量删除
	 * @param request
	 * @param response
	 */
	@RequestMapping("deleteLog")
	public void delLog(HttpServletRequest request,HttpServletResponse response) {
		JSONObject result=new JSONObject();
		try {
			String ids[] = request.getParameter("ids").split(",");
			for (String id : ids) {
				logService.deleteLog(Long.parseLong(id));
			}	
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	/**
	 * 备份
	 */
	@RequestMapping("backup")
	public void backup(HttpServletRequest request,HttpServletResponse response){
		JSONObject result = new JSONObject();
		try {
			String time = DateUtil.formatTime(new Date(), "yyyyMMddHHmmss");
		    String excelName = "手动备份"+time;
			Log log = new Log();
			List<Log> list = logService.findLog(log);
			String[] handers = {"序号","操作人","IP地址","操作时间","操作模块","操作类型","详情"};
			// 1导入硬盘
			ExportExcelToDisk(request,handers,list, excelName);
			// 2导出的位置放入attachment表
			Attachment attachment = new Attachment();
			attachment.setAttachmentname(excelName+".xls");
			attachment.setAttachmentpath("logs/backup");
			attachment.setAttachmenttime(new Date());
			attachmentService.insertAttachment(attachment);
			// 3删除log表
			logService.truncateLog();
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("", "对不起，备份失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	
	// 导出到硬盘
	@SuppressWarnings("resource")
	private void ExportExcelToDisk(HttpServletRequest request,
								   String[] handers, List<Log> list, String excleName) throws Exception {
		
		try {
			HSSFWorkbook wb = new HSSFWorkbook();//创建工作簿
			HSSFSheet sheet = wb.createSheet("操作记录备份");//第一个sheet
			HSSFRow rowFirst = sheet.createRow(0);//第一个sheet第一行为标题
			rowFirst.setHeight((short) 500);
			for (int i = 0; i < handers.length; i++) {
				sheet.setColumnWidth((short) i, (short) 4000);// 设置列宽
			}
			//写标题了
			for (int i = 0; i < handers.length; i++) {
			    //获取第一行的每一个单元格
			    HSSFCell cell = rowFirst.createCell(i);
			    //往单元格里面写入值
			    cell.setCellValue(handers[i]);
			}
			for (int i = 0;i < list.size(); i++) {
			    //获取list里面存在是数据集对象
			    Log log = list.get(i);
			    //创建数据行
			    HSSFRow row = sheet.createRow(i+1);
			    //设置对应单元格的值
			    row.setHeight((short)400);   // 设置每行的高度
			    //"序号","操作人","IP地址","操作时间","操作模块","操作类型","详情"
			    row.createCell(0).setCellValue(i+1);
			    row.createCell(1).setCellValue(log.getUsername());
			    row.createCell(2).setCellValue(log.getIp());
			    row.createCell(3).setCellValue(log.getCreatetime());
			    row.createCell(4).setCellValue(log.getOperation());
			    row.createCell(5).setCellValue(log.getModule());
			    row.createCell(6).setCellValue(log.getContent());
			}
			//写出文件（path为文件路径含文件名）
				OutputStream os;
				File file = new File(request.getSession().getServletContext().getRealPath("/")+"logs"+File.separator+"backup"+File.separator+excleName+".xls");
				
				if (!file.exists()){//若此目录不存在，则创建之  
					file.createNewFile();  
					logger.debug("创建文件夹路径为："+ file.getPath());  
	            } 
				os = new FileOutputStream(file);
				wb.write(os);
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
	}



	@RequestMapping("downloadLog4j")
	public ResponseEntity<byte[]> downloadLog4j(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String path = PropertiesUtil.url;
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		String fileName = new String("ssm.log".getBytes("UTF-8"), "iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
	}

	
}
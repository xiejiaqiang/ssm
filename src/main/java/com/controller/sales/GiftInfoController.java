package com.controller.sales;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.config.util.ConfigUtil;
import com.controller.systemManage.LogController;
import com.entity.po.file.TFileInfo;
import com.entity.po.sales.TGiftInfo;
import com.entity.po.systemManage.Operation;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageInfo;
import com.service.file.IFileInfoService;
import com.service.impl.systemManage.OperationServiceImpl;
import com.service.sales.IGiftInfoService;
import com.util.DateUtil;
import com.util.FtpUtils;
import com.util.StringUtil;
import com.util.WriterUtil;
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
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("giftInfo")
public class GiftInfoController extends LogController {
	static Logger LOGGER = LoggerFactory.getLogger(GiftInfoController.class);

	@Autowired
	private IGiftInfoService giftInfoService;
	@Autowired
	private OperationServiceImpl operationService;
	private FtpUtils ftpUtils = new FtpUtils();
	@Autowired
	private IFileInfoService fileInfoService;
	@RequestMapping("giftInfoIndex")
	public String index(HttpServletRequest request, Integer menuid) throws Exception {
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		return "sales/giftInfo";
	}

	@RequestMapping(value="giftInfoList",method= RequestMethod.POST)
	public void giftInfoList(HttpServletRequest request, HttpServletResponse response, TGiftInfo giftInfo, String offset, String limit) throws Exception{
		try {
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			Integer pageSize = StringUtil.isEmpty(limit)? ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<TGiftInfo> orderInfoList= giftInfoService.findGiftInfo(giftInfo,pageNum,pageSize,ordername,order);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",orderInfoList.getTotal() );
			jsonObj.put("rows", orderInfoList.getList());
			WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("礼品信息展示错误",e);
			throw e;
		}
	}

	// 新增或修改
	@RequestMapping("reserveGiftInfo")
	public void reserveGiftInfo(HttpServletRequest request, TGiftInfo giftInfo, HttpServletResponse response){
		Long id = giftInfo.getId();
		JSONObject result=new JSONObject();
		try {
			if (id != null) {   // Id不为空 说明是修改
				int status = giftInfoService.updateGiftInfo(giftInfo);
				    result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，更新失败");
					WriterUtil.write(response, result.toString());
					return;
				}
			}else {
				int status =giftInfoService.addGiftInfo(giftInfo);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，新增失败");
					WriterUtil.write(response, result.toString());
					return;
				}
			}
		} catch (Exception e) {
			LOGGER.error("保存礼品信息错误",e);
			if(e instanceof DuplicateKeyException){
				result.put("errorMsg", "操作失败!该礼品已存在!");
			}else {
				result.put("errorMsg", "对不起，操作失败");
			}
			result.put("success", true);
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping("deleteGiftInfo")
	public void deleteGiftInfo(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (int i=0 ;i<ids.length;i++) {
				removeGiftImg(Long.valueOf(ids[i]));
				giftInfoService.deleteGiftInfo(Long.valueOf(ids[i]));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			LOGGER.error("删除礼品信息错误[]",JSON.toJSONString(e));
			result.put("success", false);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}

	private void removeGiftImg(Long id){
		//根据id查询数据
		try {
			TGiftInfo t = giftInfoService.findGiftInfoById(id);
			List<TFileInfo> fileInfo = fileInfoService.findFileInfoByBathNo(t.getGiftImg());
			if (fileInfo !=null && fileInfo.size()>0){
				for (int i = 0; i <fileInfo.size() ; i++) {
					//下载图片
					boolean delFlag = ftpUtils.deleteFile(fileInfo.get(i).getFilePath(),fileInfo.get(i).getSavefileName());
					LOGGER.info("图片[{}]删除结果:[{}]",fileInfo.get(i).getSavefileName(),delFlag);
				}
			}
			//根据批次号删除 图片表
			fileInfoService.deleteFileInfoByBatchNo(t.getGiftImg());
		}catch (Exception e){
			LOGGER.error("batchUpload 删除图片失败，失败信息:[{}]", JSON.toJSON(e.getMessage()));

		}
	};
	@RequestMapping("batchUpload")
	@ResponseBody
	public JSONObject batchUpload(@RequestParam MultipartFile[] txt_file,String upload_id, HttpSession session , HttpServletResponse response) throws Exception {
		BathInsertResultVO res = new BathInsertResultVO();
		JSONObject result = new JSONObject();
		TGiftInfo giftInfo = giftInfoService.findGiftInfoById(Long.valueOf(upload_id));
		String batchNo ="";
		if(StringUtil.isEmpty(giftInfo.getGiftImg())){
			batchNo = StringUtil.getRandomString(30);
		}else {
			batchNo = giftInfo.getGiftImg();
		}

		try {
			for (MultipartFile file: txt_file) {
				//file.getOriginalFilename()方法 得到上传时的文件名
				String fileName = file.getOriginalFilename();
				//截取文件名的后缀
				String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
				//生成新的文件名
				String saveFileName = "GiftInfo_"+upload_id+"_"+DateUtil.getChar14()+"."+suffix;
				LOGGER.info("batchUpload 上传礼品图片[{}]", fileName);
				ftpUtils.uploadFile("/img",saveFileName, file.getInputStream());
				LOGGER.info("batchUpload 上传礼品图片[{}]成功", fileName);
				//保存文件信息表
				TFileInfo t = new TFileInfo();
				t.setBatchNo(batchNo);
				t.setFileName(fileName);
				t.setFilePath("/img");
				t.setFileSuffix(suffix);
				t.setSavefileName(saveFileName);
				fileInfoService.addFileInfo(t);
			}
			//更新礼品表
			giftInfo.setGiftImg(batchNo);
			giftInfoService.updateGiftInfo(giftInfo);
			result.put("success", true);
			return result;
		} catch (Exception e) {
			LOGGER.error("batchUpload 上传礼品图片，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "上传礼品图片失败");
			result.put("success", false);
			return result;
		}
	}

	@RequestMapping("viewImg")
	@ResponseBody
	public JSONObject viewImg(Long id, HttpSession session , HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		//根据id查询数据
		TGiftInfo t = giftInfoService.findGiftInfoById(id);
		List<TFileInfo> fileInfo = fileInfoService.findFileInfoByBathNo(t.getGiftImg());
		try {
			for (int i = 0; i <fileInfo.size() ; i++) {
				//下载图片
				String img = ftpUtils.downloadBase64Img(fileInfo.get(i).getFilePath(),fileInfo.get(i).getSavefileName(),fileInfo.get(i).getFileSuffix());
				fileInfo.get(i).setFilePath(img);
			}
			result.put("fileInfo",fileInfo);
			result.put("success", true);
			return result;
		}catch (Exception e){
			LOGGER.error("viewImg 获取图片失败，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "获取图片失败");
			result.put("success", false);
			return result;
		}
	}
}

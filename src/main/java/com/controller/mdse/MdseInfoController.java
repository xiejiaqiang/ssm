package com.controller.mdse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.config.util.ConfigUtil;
import com.constant.ProvinceMaping;
import com.controller.systemManage.LogController;
import com.entity.po.file.TFileInfo;
import com.entity.po.mdse.*;
import com.entity.po.sales.TGiftInfo;
import com.entity.po.systemManage.Operation;
import com.entity.po.systemManage.Role;
import com.entity.po.systemManage.User;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageInfo;
import com.service.file.IFileInfoService;
import com.service.impl.systemManage.OperationServiceImpl;
import com.service.mdse.*;
import com.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("mdseInfo")
public class MdseInfoController extends LogController {
	static Logger LOGGER = LoggerFactory.getLogger(MdseInfoController.class);

	@Autowired
	private IMdseInfoService mdseInfoService;
	@Autowired
	private IMdsePriceService mdsePriceService;
	@Autowired
	private IMdseCatService mdseCatService;
	@Autowired
	private OperationServiceImpl operationService;
	@Autowired
	private IMdseRegionService mdseRegionService;
	@Autowired
	private IFileInfoService fileInfoService;
	@Autowired
	private IMdseSalesService mdseSalesService;

	@RequestMapping("mdseInfoIndex")
	public String index(HttpServletRequest request, Integer menuid) throws Exception {
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		try {
			JSONArray jsonArray = mdseCatService.getMdseCatsByParentId();
			List<TMdseCat> cat = mdseCatService.findMdseCat(new TMdseCat());
			JSONArray mdseCatList = new JSONArray();
			for (int i=0;i<cat.size();i++){
				JSONObject obj = new JSONObject();
				obj.put("id", cat.get(i).getId());
				obj.put("name", cat.get(i).getMdseCatName());
				mdseCatList.add(obj);
			}
			request.setAttribute("mdseCatTree", jsonArray);
			request.setAttribute("mdseCatList", mdseCatList);
		} catch (Exception e) {
			LOGGER.error("加载产品分类信息错误",e);
			throw e;
		}
		return "mdse/mdseInfo";
	}

	@RequestMapping(value="mdseInfoList",method= RequestMethod.POST)
	public void mdseInfoList(HttpServletRequest request, HttpServletResponse response, TMdseInfo mdseInfo, String offset, String limit) throws Exception{
		try {
			String end = request.getParameter("end");
			String start = request.getParameter("start");
			BigDecimal endAmount = null;
			BigDecimal startAmount = null;
			if(StringUtil.isNotEmpty(end)){
				endAmount = new BigDecimal(end);
			}
			if(StringUtil.isNotEmpty(start)){
				startAmount = new BigDecimal(start);
			}
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			Integer pageSize = StringUtil.isEmpty(limit)? ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			List<String> catIds = null;
			if(StringUtil.isNotEmpty(mdseInfo.getMdseCat())){
				catIds = mdseCatService.getMdseCatsByParentId(mdseInfo.getMdseCat());
			}
			PageInfo<TMdseInfo> orderInfoList= mdseInfoService.findMdseInfo(mdseInfo,pageNum,pageSize,ordername,order, startAmount, endAmount,catIds);
			request.setAttribute("start", start);
			request.setAttribute("end", end);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",orderInfoList.getTotal() );
			jsonObj.put("rows", orderInfoList.getList());
			WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("商品信息展示错误",e);
			throw e;
		}
	}

	// 新增或修改
	@RequestMapping("reserveMdseInfo")
	public void reserveMdseInfo(HttpServletRequest request, TMdseInfo mdseInfo, String txt_Date_Time, HttpServletResponse response){
		Long id = mdseInfo.getId();
		JSONObject result=new JSONObject();
			mdseInfo.setMdseNo(mdseInfo.getModel());
		if(StringUtil.isEmpty(txt_Date_Time)){
			mdseInfo.setCreateTime(new Date());
		}else {
			Date date = DateUtil.TimeStampToDate(txt_Date_Time);
			mdseInfo.setCreateTime(date);
		}
		//获取商品价格
		TMdsePrice mdsePrice = new TMdsePrice();
		CopyUtils.copyBean(mdseInfo, mdsePrice);
		mdsePrice.setId(mdseInfo.getPriceId());
		try {
			if (id != null) {   // Id不为空 说明是修改
				mdseInfo.setUpdateTime(new Date());
				int status = mdseInfoService.updateMdseInfo(mdseInfo);
				    result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，更新失败");
					WriterUtil.write(response, result.toString());
					return;
				}
			}else {
				mdseInfo.setCreateTime(new Date());
				int status =mdseInfoService.addMdseInfo(mdseInfo);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，新增失败");
					WriterUtil.write(response, result.toString());
					return;
				}
			}
			if (mdsePrice.getId() != null) {   // 商品价格id不为空 说明是修改
				int status = mdsePriceService.updateMdsePrice(mdsePrice);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "商品新增成功，商品价格新增失败");
				}
			}else {
				//初始化价格
				if(mdsePrice.getBuyingPrice() == null){
					mdsePrice.setBuyingPrice(BigDecimal.ZERO);
				}
				if(mdsePrice.getRetailPrice() == null){
					mdsePrice.setRetailPrice(BigDecimal.ZERO);
				}
				if(mdsePrice.getFloorPrice() == null){
					mdsePrice.setFloorPrice(BigDecimal.ZERO);
				}
				int status =mdsePriceService.addMdsePrice(mdsePrice);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "商品新增成功，商品价格更新失败");
				}
			}
		} catch (Exception e) {
			LOGGER.error("保存商品信息错误",e);
			if(e instanceof DuplicateKeyException){
				result.put("errorMsg", "操作失败!该商品已存在!");
			}else {
				result.put("errorMsg", "对不起，操作失败");
			}
			result.put("success", true);
		}
		WriterUtil.write(response, result.toString());
	}

	// 新增或修改
	@RequestMapping("reserveMdsePrice")
	public void reserveMdsePrice(HttpServletRequest request, TMdsePrice mdsePrice, HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			if (mdsePrice.getId() != null) {   // 商品价格id不为空 说明是修改
				int status = mdsePriceService.updateMdsePrice(mdsePrice);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "商品新增成功，商品价格新增失败");
				}
			}else {
				//初始化价格
				if(mdsePrice.getBuyingPrice() == null){
					mdsePrice.setBuyingPrice(BigDecimal.ZERO);
				}
				if(mdsePrice.getRetailPrice() == null){
					mdsePrice.setRetailPrice(BigDecimal.ZERO);
				}
				if(mdsePrice.getFloorPrice() == null){
					mdsePrice.setFloorPrice(BigDecimal.ZERO);
				}
				int status =mdsePriceService.addMdsePrice(mdsePrice);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "商品新增成功，商品价格更新失败");
				}
			}
		} catch (Exception e) {
			LOGGER.error("保存商品信息错误",e);
			if(e instanceof DuplicateKeyException){
				result.put("errorMsg", "操作失败!该商品已存在!");
			}else {
				result.put("errorMsg", "对不起，操作失败");
			}
			result.put("success", true);
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping("deleteMdseInfo")
	public void deleteMdseInfo(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (int i=0 ;i<ids.length;i++) {
				TMdseInfo mdseInfo = mdseInfoService.findMdseInfoById(Long.valueOf(ids[i]));
				mdseInfoService.deleteMdseInfo(Long.valueOf(ids[i]));
				mdsePriceService.deleteByMdseNo(mdseInfo.getMdseNo());
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			LOGGER.error("删除商品信息错误[]",JSON.toJSONString(e));
			result.put("success", false);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping(value="export",method= RequestMethod.GET)
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception{
		TMdseInfo mdseInfo = new TMdseInfo();
		String end = request.getParameter("end");
		String start = request.getParameter("start");
		String mdseName = request.getParameter("txt_mdseName");
		String model = request.getParameter("txt_model");
		String colour = request.getParameter("txt_colour");
		String mdseCat = request.getParameter("txt_mdseCat");
		String mdseStatus = request.getParameter("txt_mdseStatus");
		mdseInfo.setMdseName(mdseName);
		mdseInfo.setModel(model);
		mdseInfo.setColour(colour);
		mdseInfo.setMdseCat(mdseCat);
		mdseInfo.setMdseStatus(mdseStatus);
		Integer pageSize = 9999999;
		Integer pageNum =  1;
		PageInfo<TMdseInfo> mdseInfoList= mdseInfoService.findMdseInfo(mdseInfo,pageNum,pageSize,null,null, null, null,  null);
		List<TMdseInfo> mdseInfos = new ArrayList<TMdseInfo>();
		mdseInfos = CopyUtils.copyList(mdseInfoList.getList(), TMdseInfo.class);
		String [] str = new String[]{"主键","商品编号","商品名称","标题","颜色",
				"型号","商品分类","商品库存","商品状态","品牌","系列","卖点",
				"图片ID","参数1","参数2","创建时间","更新时间","进货价","零售指导价",
				"底价","活动价","利润","利润率"};
		ExcelUtils.exportExcel("商品信息_"+DateUtil.getChar8()+".xls",str,mdseInfos,response,"yyyy-MM-dd");
	}

	@RequestMapping(value="findMdseRegionByMdseCat",method= RequestMethod.POST)
	public void findMdseRegionByMdseCat(HttpServletRequest request, HttpServletResponse response, TMdseInfo mdseInfo, String offset, String limit) throws Exception{
		JSONObject result=new JSONObject();
		JSONArray jsonArray = new JSONArray();
		try {
			Map map = new HashMap();
			List<TMdseRegion> mdseRegionList= mdseRegionService.findMdseRegionByMdseCat(null);
			for (TMdseRegion  mdseRegion : mdseRegionList) {
				map.put(ProvinceMaping.getJvectormapCn(mdseRegion.getProvince()), mdseRegion.getNumber());
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id",ProvinceMaping.getJvectormapCn(mdseRegion.getProvince()));
				jsonObject.put("name",mdseRegion.getProvince());
				//jsonObject.put("event","点击查看销售详情");
				jsonObject.put("event", mdseRegion.getNumber());
				jsonObject.put("url","");
				jsonArray.add(jsonObject);
			}

			result.put("data",map);
			result.put("dataStatus",jsonArray);
			WriterUtil.write(response,result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("商品销售地区信息获取失败",e);
			throw e;
		}
	}


	@RequestMapping("batchUpload")
	@ResponseBody
	public JSONObject batchUpload(@RequestParam MultipartFile[] txt_file,String upload_id, HttpSession session , HttpServletResponse response) throws Exception {
		BathInsertResultVO res = new BathInsertResultVO();
		JSONObject result = new JSONObject();
		TMdseInfo mdseInfo = mdseInfoService.findMdseInfoById(Long.valueOf(upload_id));
		String batchNo ="";
		if(StringUtil.isEmpty(mdseInfo.getPictureId())){
			batchNo = StringUtil.getRandomString(30);
		}else {
			batchNo = mdseInfo.getPictureId();
		}

		try {
			for (MultipartFile file: txt_file) {
				//file.getOriginalFilename()方法 得到上传时的文件名
				String fileName = file.getOriginalFilename();
				//截取文件名的后缀
				String suffix = fileName.substring(fileName.lastIndexOf(".")+1);
				//生成新的文件名
				String saveFileName = "MdseInfo_"+upload_id+"_"+DateUtil.getChar17()+"."+suffix;
				LOGGER.info("batchUpload 上传礼品图片[{}]", fileName);
				DxlFileUtil.upFile(file.getInputStream(),saveFileName,"/home/ftp/img/mdse");
				LOGGER.info("batchUpload 上传礼品图片[{}]成功", fileName);
				//保存文件信息表
				TFileInfo t = new TFileInfo();
				t.setBatchNo(batchNo);
				t.setFileName(fileName);
				t.setFilePath("/home/ftp/img/mdse");
				t.setFileSuffix(suffix);
				t.setSavefileName(saveFileName);
				fileInfoService.addFileInfo(t);
			}
			//更新商品表
			mdseInfo.setPictureId(batchNo);
			mdseInfoService.updateMdseInfo(mdseInfo);
			result.put("success", true);
			return result;
		} catch (Exception e) {
			LOGGER.error("batchUpload 上传礼品图片，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "上传礼品图片失败");
			result.put("success", false);
			return result;
		}
	}


	@RequestMapping("viewMdseImg")
	@ResponseBody
	public JSONObject viewMdseImg(Long id, HttpSession session , HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		//根据id查询数据
		TMdseInfo t = mdseInfoService.findMdseInfoById(id);
		List<TFileInfo> fileInfo = new ArrayList<TFileInfo>();
		try {
		if(StringUtil.isNotEmpty(t.getPictureId())){
			fileInfo = fileInfoService.findFileInfoByBathNo(t.getPictureId());
				for (int i = 0; i <fileInfo.size() ; i++) {
					//下载图片
					String img = DxlFileUtil.downloadBase64Img(fileInfo.get(i).getFilePath(),fileInfo.get(i).getSavefileName(),fileInfo.get(i).getFileSuffix());
					fileInfo.get(i).setFilePath(img);
				}
		}
			result.put("mdseInfo",t);
			result.put("fileInfo",fileInfo);
			result.put("success", true);
			return result;
		}catch (Exception e){
			LOGGER.error("viewMdseImg 获取图片失败，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "获取图片失败");
			result.put("success", false);
			return result;
		}
	}


	@RequestMapping(value="/bathMdseSales", method = RequestMethod.POST)
	@ResponseBody
		public JSONObject bathMdseSales(@RequestParam(value = "salesChannelTypes[]") String[]  salesChannelTypes,HttpServletRequest request, HttpSession session , HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (int i=0 ;i<ids.length;i++) {
				TMdseInfo mdseInfo = mdseInfoService.findMdseInfoById(Long.valueOf(ids[i]));
				//查询是否存在
				for (String salesChannelType: salesChannelTypes) {
					TMdseSales tMdseSales = new TMdseSales();
					tMdseSales.setMdseNo(mdseInfo.getMdseNo());
					tMdseSales.setSalesChannel(salesChannelType);
					List<TMdseSales> mdseSales = mdseSalesService.findMdseSales(tMdseSales);
					if (mdseSales ==null || mdseSales.size() == 0){
						//同步到销售渠道
						tMdseSales.setActivityPrice(mdseInfo.getTradePrice());//活动价
						tMdseSales.setDailyPrice(mdseInfo.getRetailPrice());//日常售价
						tMdseSales.setSalesStatus("0");
						try {
							mdseSalesService.addMdseSales(tMdseSales);
						}catch (Exception e){
							LOGGER.error(" 新增销售渠道信息，失败信息:[{}]", JSON.toJSON(e.getMessage()));
						}
					}
				}
			}

			result.put("success", true);
			return result;
		}catch (Exception e){
			LOGGER.error("viewMdseImg 批量同步销售渠道失败，失败信息:[{}]", JSON.toJSON(e.getMessage()));
			result.put("errorMsg", "批量同步销售渠道失败");
			result.put("success", false);
			return result;
		}
	}

}

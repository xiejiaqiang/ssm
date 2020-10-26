package com.controller.mdse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.config.util.ConfigUtil;
import com.controller.systemManage.LogController;
import com.entity.po.mdse.TMdseCat;
import com.entity.po.mdse.TMdseInfo;
import com.entity.po.systemManage.Operation;
import com.entity.po.systemManage.Role;
import com.entity.po.systemManage.User;
import com.entity.vo.BathInsertResultVO;
import com.github.pagehelper.PageInfo;
import com.service.impl.systemManage.OperationServiceImpl;
import com.service.mdse.IMdseCatService;
import com.service.mdse.IMdseInfoService;
import com.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("mdseInfo")
public class MdseInfoController extends LogController {
	static Logger LOGGER = LoggerFactory.getLogger(MdseInfoController.class);

	@Autowired
	private IMdseInfoService mdseInfoService;
	@Autowired
	private IMdseCatService mdseCatService;
	@Autowired
	private OperationServiceImpl operationService;

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
	public void reserveMdseInfo(HttpServletRequest request, TMdseInfo mdseInfo, HttpServletResponse response){
		Long id = mdseInfo.getId();
		JSONObject result=new JSONObject();
		try {
			if (id != null) {   // Id不为空 说明是修改
				mdseInfo.setCreateTime(new Date());
				int status = mdseInfoService.updateMdseInfo(mdseInfo);
					result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，更新失败");
				}
			}else {
				mdseInfo.setCreateTime(new Date());
				int status =mdseInfoService.addMdseInfo(mdseInfo);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，新增失败");
				}
			}
		} catch (Exception e) {
			LOGGER.error("保存商品信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping("deleteMdseInfo")
	public void deleteMdseInfo(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				mdseInfoService.deleteMdseInfo(Long.valueOf(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			LOGGER.error("删除商品信息错误[]",JSON.toJSONString(e));
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
				"底价","批发价","利润","利润率"};
		ExcelUtils.exportExcel("商品信息_"+DateUtil.getChar8()+".xls",str,mdseInfos,response,"yyyy-MM-dd");
	}

}
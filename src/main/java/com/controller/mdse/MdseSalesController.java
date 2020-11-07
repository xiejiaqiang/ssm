package com.controller.mdse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.config.util.ConfigUtil;
import com.controller.systemManage.LogController;
import com.entity.po.mdse.TMdseCat;
import com.entity.po.mdse.TMdseInfo;
import com.entity.po.mdse.TMdseRegion;
import com.entity.po.mdse.TMdseSales;
import com.entity.po.systemManage.Operation;
import com.github.pagehelper.PageInfo;
import com.service.impl.systemManage.OperationServiceImpl;
import com.service.mdse.IMdseCatService;
import com.service.mdse.IMdseInfoService;
import com.service.mdse.IMdseRegionService;
import com.service.mdse.IMdseSalesService;
import com.util.StringUtil;
import com.util.WriterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mdseSales")
public class MdseSalesController extends LogController {
	static Logger LOGGER = LoggerFactory.getLogger(MdseSalesController.class);

	@Autowired
	private IMdseSalesService mdseSalesService;
	@Autowired
	private OperationServiceImpl operationService;
	@Autowired
	private IMdseInfoService mdseInfoService;
	@Autowired
	private IMdseCatService mdseCatService;
	@Autowired
	private IMdseRegionService mdseRegionService;

	@RequestMapping("mdseSalseIndex")
	public String index(HttpServletRequest request, Integer menuid) throws Exception {
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		return "mdse/mdseSalse";
	}
	@RequestMapping(value="mdseSalseList",method= RequestMethod.POST)
	public void userList(HttpServletRequest request, HttpServletResponse response, TMdseSales mdseSales, String offset, String limit) throws Exception{
		try {
			/*String end = request.getParameter("end");
			String start = request.getParameter("start");*/
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			Integer pageSize = StringUtil.isEmpty(limit)? ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<TMdseSales> orderInfoList= mdseSalesService.findMdseSales(mdseSales,pageNum,pageSize,ordername,order);
			/*request.setAttribute("start", start);
			request.setAttribute("end", end);*/
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",orderInfoList.getTotal() );
			jsonObj.put("rows", orderInfoList.getList());
			WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("商品销售渠道展示错误",e);
			throw e;
		}
	}

	// 新增或修改
	@RequestMapping("reserveMdseSalse")
	public void reserveOrderInfo(HttpServletRequest request, TMdseSales mdseSales, HttpServletResponse response){
		Long id = mdseSales.getId();
		JSONObject result=new JSONObject();
		try {
			//查询是否存在
			TMdseSales tMdseSales = new TMdseSales();
			tMdseSales.setMdseNo(mdseSales.getMdseNo());
			tMdseSales.setSalesChannel(mdseSales.getSalesChannel());
			List<TMdseSales> list = mdseSalesService.findMdseSales(tMdseSales);
			if (list != null && !list.isEmpty()){
				//新增
				if(id == null){
					result.put("success", false);
					result.put("errorMsg", "新增失败,该销售渠道已有对应商品,不可重复增加");
				}else {
					if (id != list.get(0).getId()){
						result.put("success", false);
						result.put("errorMsg", "更新失败,该销售渠道已有对应商品,不可重复增加");
					}
				}
			}

			if (id != null) {   // Id不为空 说明是修改
				int status = mdseSalesService.updateMdseSales(mdseSales);
					result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，更新失败");
				}
			}else {
				int status =mdseSalesService.addMdseSales(mdseSales);
				result.put("success", true);
				if (status == 0){
					result.put("success", false);
					result.put("errorMsg", "对不起，新增失败");
				}
			}
		} catch (Exception e) {
			LOGGER.error("保存商品渠道信息错误{}",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}

	@RequestMapping("deleteMdseSalse")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				mdseSalesService.deleteMdseSales(Long.valueOf(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			LOGGER.error("删除用户信息错误[{}]",JSON.toJSONString(e));
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
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


	@RequestMapping("mdseSalseMap")
	public String mdseSalseMap(HttpServletRequest request, Integer menuid) throws Exception {
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		try {
			JSONArray jsonArray = mdseCatService.getMdseCatsByParentId();
			//查询所有分类
			TMdseCat tMdseCat = new  TMdseCat();
			tMdseCat.setParentId(-1l);
			List<TMdseCat> list = mdseCatService.findMdseCat(tMdseCat);
			JSONArray mdseRegionsList = new JSONArray();
			for (TMdseCat mdseCat:list) {
				JSONObject obj = new JSONObject();
				List<String> mdseCats = mdseCatService.getMdseCatsByParentId(mdseCat.getId().toString());
				List<TMdseRegion> mdseRegions = mdseRegionService.findMdseRegionByMdseCat(mdseCats);
				obj.put("name", mdseCat.getMdseCatName());
				obj.put("data", mdseRegions);
				mdseRegionsList.add(obj);
			}
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
			request.setAttribute("mdseRegionsList", mdseRegionsList);
		} catch (Exception e) {
			LOGGER.error("加载信息错误",e);
			throw e;
		}
		request.setAttribute("operationList", operationList);
		return "mdse/mdseEcharts";
	}


	@RequestMapping("getRegionData")
	public void getRegionData(HttpServletRequest request,Long parentId, HttpServletResponse response) throws Exception {
		JSONObject result=new JSONObject();
		//查询所有分类
		TMdseCat tMdseCat = new  TMdseCat();
		tMdseCat.setParentId(parentId);
		List<TMdseCat> list = mdseCatService.findMdseCat(tMdseCat);
		JSONArray mdseRegionsList = new JSONArray();
		JSONArray jSONArraySeries  = new JSONArray();
		long maxValue =0;
		long countOrderSize =0;
		boolean isMdseCatId = false;
		if (list == null || list.size()==0){
			tMdseCat = new  TMdseCat();
			tMdseCat.setId(parentId);
			list = mdseCatService.findMdseCat(tMdseCat);
			isMdseCatId = true;
		}
		//判断是否是最子节点 最子节点直接取产品销售信息
		if(isMdseCatId){
			TMdseRegion t = new TMdseRegion();
			t.setMdseCat(parentId.toString());
			List<TMdseRegion> mdseRegions = mdseRegionService.findMdseRegionGroupMdseNo(parentId.toString());
			if(mdseRegions == null || mdseRegions.size()==0){
				JSONArray mdseRegionsValueList = new JSONArray();
				JSONObject objSeries = new JSONObject();
				objSeries.put("name", "");
				setSeries(objSeries);
				JSONObject obj = new JSONObject();
				obj.put("name", "");
				objSeries.put("data", mdseRegionsValueList);
				obj.put("data", mdseRegionsValueList);
				mdseRegionsList.add(obj);
				jSONArraySeries.add(objSeries);
			}else{
				for (TMdseRegion mdseRegion:mdseRegions) {
					JSONArray mdseRegionsValueList = new JSONArray();
					JSONObject objSeries = new JSONObject();
					objSeries.put("name", mdseRegion.getMdseNo());
					setSeries(objSeries);
					JSONObject obj = new JSONObject();
					obj.put("name", mdseRegion.getMdseNo());
					//查询
					List<TMdseRegion> mdseRegions2 = mdseRegionService.findMdseRegionByMdseNoGroup(mdseRegion.getMdseNo());
					for (int i=0;i<mdseRegions2.size();i++){
						if(maxValue<mdseRegions2.get(i).getNumber()){
							maxValue = mdseRegions2.get(i).getNumber();
						}
						countOrderSize = countOrderSize+mdseRegions2.get(i).getNumber();
						JSONObject ob = new JSONObject();
						ob.put("name", mdseRegions2.get(i).getProvince());
						ob.put("value", mdseRegions2.get(i).getNumber());
						mdseRegionsValueList.add(ob);
					};
					objSeries.put("data", mdseRegionsValueList);
					obj.put("data", mdseRegionsValueList);
					mdseRegionsList.add(obj);
					jSONArraySeries.add(objSeries);
				}
			}
			result.put("countOrderSize", countOrderSize);
			result.put("maxValue", maxValue);
			result.put("mdseRegionsList", mdseRegionsList);
			result.put("seriesList", jSONArraySeries);
		}else {
			for (TMdseCat mdseCat:list) {
				JSONArray mdseRegionsValueList = new JSONArray();
				JSONObject objSeries = new JSONObject();
				objSeries.put("name", mdseCat.getMdseCatName());
				setSeries(objSeries);
				JSONObject obj = new JSONObject();
				List<String> mdseCats = mdseCatService.getMdseCatsByParentId(mdseCat.getId().toString());
				List<TMdseRegion> mdseRegions = new ArrayList<TMdseRegion>();
				mdseRegions = mdseRegionService.findMdseRegionByMdseCat(mdseCats);
				obj.put("name", mdseCat.getMdseCatName());
				for (int i=0;i<mdseRegions.size();i++){
					if(maxValue<mdseRegions.get(i).getNumber()){
						maxValue = mdseRegions.get(i).getNumber();
					}
					countOrderSize = countOrderSize+mdseRegions.get(i).getNumber();
					JSONObject ob = new JSONObject();
					ob.put("name", mdseRegions.get(i).getProvince());
					ob.put("value", mdseRegions.get(i).getNumber());
					mdseRegionsValueList.add(ob);
				};
				objSeries.put("data", mdseRegionsValueList);
				obj.put("data", mdseRegionsValueList);
				mdseRegionsList.add(obj);
				jSONArraySeries.add(objSeries);
			}
			result.put("maxValue", maxValue);
			result.put("countOrderSize", countOrderSize);
			result.put("mdseRegionsList", mdseRegionsList);
			result.put("seriesList", jSONArraySeries);
		}

		WriterUtil.write(response, result.toString());
	}

	private void setSeries(JSONObject objSeries){
		objSeries.put("type", "map");
		objSeries.put("mapType", "china");
		objSeries.put("roam", false);
		JSONObject itemStyle = new JSONObject();
		JSONObject objNormal = new JSONObject();
		JSONObject objLabel = new JSONObject();
		objLabel.put("show", true);
		objNormal.put("label", objLabel);
		itemStyle.put("normal", objNormal);
		JSONObject objEmphasis = new JSONObject();
		JSONObject objLabel2 = new JSONObject();
		objLabel2.put("show",true);
		objEmphasis.put("label",objLabel2);
		itemStyle.put("emphasis", objEmphasis);
		objSeries.put("itemStyle", itemStyle);
	}
}

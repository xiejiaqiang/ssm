package com.controller.mdse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.po.mdse.TMdseCat;
import com.entity.po.systemManage.Operation;
import com.service.impl.systemManage.OperationServiceImpl;
import com.service.mdse.IMdseCatService;
import com.util.StringUtil;
import com.util.StringUtils;
import com.util.WriterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("mdseCat")
@Controller
public class MdseCatController {

	@Autowired
	private IMdseCatService mdseCatService;
	@Autowired
	private OperationServiceImpl operationService;

	static Logger logger = LoggerFactory.getLogger(MdseCatController.class);
	
	
	@RequestMapping("mdseCatIndex")
	public String index(HttpServletRequest request,HttpServletResponse response,Integer menuid){
		String currentOperationIds = (String) request.getSession().getAttribute("currentOperationIds");
		String[] OperationIdArr = currentOperationIds.split(",");
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		for (Operation operation : operationList) {
			if(StringUtil.existStrArr(operation.getOperationid().toString(),OperationIdArr)){
				map.put(operation.getOperationcode(),true);
			}else{
				map.put(operation.getOperationcode(),false);
			}
		}
		request.setAttribute("operationInfo", map);
		return "mdse/mdseCat";
	}
	
	@RequestMapping("treeGridMdseCat")
	public void treeGridMenu(HttpServletRequest request,HttpServletResponse response){
		try {
			String parentId = request.getParameter("parentId");
			JSONArray jsonArray = getListByParentId(parentId,0);
			WriterUtil.write(response, jsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("产品类型展示错误",e);
		}
	}
	
	public JSONArray getListByParentId(String parentId, int l)throws Exception{
		JSONArray jsonArray = this.getTreeGridMenuByParentId(parentId,l);
		JSONArray resultJsonArray = new JSONArray();
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			resultJsonArray.add(jsonObject);
			resultJsonArray.addAll(getListByParentId(jsonObject.getString("id"),++l));
		}
		return resultJsonArray;
	}
	
	
	
	public JSONArray getTreeGridMenuByParentId(String parentId, int l)throws Exception{
		JSONArray jsonArray = new JSONArray();
		TMdseCat mdseCat = new TMdseCat();
		mdseCat.setParentId(Long.parseLong(parentId));
		List<TMdseCat> list = mdseCatService.findMdseCat(mdseCat);
		for(TMdseCat m : list){
			JSONObject jsonObject = new JSONObject();
			Long id = m.getId();
			jsonObject.put("id", id);
			jsonObject.put("creationTime", m.getCreationTime());
			jsonObject.put("parentId", m.getParentId());
			jsonObject.put("mdseCatName", m.getMdseCatName());
			jsonObject.put("mdseCatNo", m.getMdseCatNo());
			jsonObject.put("level", l);
			jsonObject.put("isLeaf", (StringUtil.isEmpty(m.getState())||"close".equals(m.getState()) ));
			jsonObject.put("parent", m.getParentId().compareTo(new Long(0))>0?m.getParentId():null);
			jsonObject.put("laoded", true);
			jsonObject.put("expanded", true);
			
			/*// 加上该页面菜单下面的按钮
			Operation operation = new Operation();
			operation.setMenuid(menuId);
			List<Operation> operaList = operationService.findOperation(operation);
			if (operaList!=null && operaList.size()>0) {
				String string = "";
				for (Operation o : operaList) {
					string += o.getOperationname() + ",";
				}
				jsonObject.put("operationnames", string.substring(0,string.length()-1));
			} else {
				jsonObject.put("operationnames", "");
			}*/
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	
	
	@RequestMapping({"reserveMdseCat"})
	public void reserveMdseCat(HttpServletRequest request, HttpServletResponse response, TMdseCat mdseCat){
		String id = mdseCat.getId()==null?"": mdseCat.getId().toString();
		if(mdseCat.getCreationTime() == null){
			mdseCat.setCreationTime(new Date());
		}
		JSONObject result = new JSONObject();
		try {
			TMdseCat catInfo = mdseCatService.existMdseCatWithCatName(mdseCat.getMdseCatName());
			if(catInfo !=null && StringUtil.isNotEmpty(catInfo.getMdseCatName())){
				if (!catInfo.getId().equals(id) || StringUtil.isNotEmpty(id)) {
					logger.warn("操作失败,该商品分类名称已存在！");
					result.put("success", true);
					result.put("errorMsg", "操作失败,该商品分类名称已存在！");
					WriterUtil.write(response, result.toString());
					return;
				}
			}

			if (StringUtil.isNotEmpty(id)) {  //更新操作
				mdseCat.setId(Long.parseLong(id));
				mdseCatService.updateMdseCat(mdseCat);
			} else {
				String parentId = mdseCat.getParentId()==null?"-1": mdseCat.getParentId().toString();
				mdseCat.setParentId(Long.parseLong(parentId));
				if (isLeaf(parentId)) {
					// 添加操作
					if("1".equals(parentId)){
						mdseCat.setState("close");
					}
					mdseCatService.addMdseCat(mdseCat);
					
					// 更新他上级状态。变成isParent
					mdseCat = new TMdseCat();
					mdseCat.setId(Long.parseLong(parentId));
					mdseCat.setState("isParent");
					mdseCatService.updateMdseCat(mdseCat);
				} else {
					// 添加操作
					if("1".equals(parentId)){
						mdseCat.setState("close");
					}
					mdseCatService.addMdseCat(mdseCat);
				}
			}
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("商品分类保存错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败！");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	
	// 判断是不是叶子节点
	public boolean isLeaf(String menuId){
		boolean flag = false;
		try {
			TMdseCat mdseCat = new TMdseCat();
			mdseCat.setParentId(Long.parseLong(menuId));
			List<TMdseCat> list = mdseCatService.findMdseCat(mdseCat);
			if (list==null || list.size()==0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("判断菜单是否叶子节点错误",e);
		}
		return flag;
	}

	@RequestMapping("deleteMdseCat")
	public void deleteMdseCat(HttpServletRequest request,HttpServletResponse response,Long id){
		JSONObject result = new JSONObject();
		try {
			TMdseCat mdseCat = mdseCatService.findMdseCat(id);
			String parentId = mdseCat.getParentId().toString();
			if (!isLeaf(id.toString())) {  //不是叶子节点，说明有子菜单，不能删除
				result.put("errorMsg", "该菜单下面有子菜单，不能直接删除");
			} else {
				mdseCat = new TMdseCat();
				mdseCat.setParentId(Long.parseLong(parentId));
				long sonNum = mdseCatService.countMdseCat(mdseCat);
				if (sonNum == 1) {  
					// 只有一个孩子，删除该孩子，且把父亲状态置为""或close
					mdseCat = new TMdseCat();
					mdseCat.setId(Long.parseLong(parentId));
					TMdseCat parentMenu = mdseCatService.findMdseCat(Long.parseLong(parentId));
					if(parentMenu != null){
						if(parentMenu.getParentId().compareTo((long)1)==0){
							mdseCat.setState("close");
						}else{
							mdseCat.setState("");
						}
						mdseCatService.updateMdseCat(mdseCat);
					}
					mdseCatService.deleteMdseCat(id);
				} else {
					//不只一个孩子，直接删除
					mdseCatService.deleteMdseCat(id);
				}
				result.put("success", true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("菜单删除错误",e);
			result.put("errorMsg", "对不起，删除失败！");
		}
		WriterUtil.write(response, result.toString());
	}
	
}

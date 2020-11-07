package com.service.mdse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.po.mdse.TMdseCat;

import java.util.List;
import java.util.Map;

public interface IMdseCatService {


	public TMdseCat findMdseCat(Long id) throws Exception;

	public Integer countMdseCat(TMdseCat t) throws Exception ;

	public List<TMdseCat> findMdseCat(TMdseCat t) throws Exception ;

	public void deleteMdseCat(Long roleid) throws Exception ;

	public void addMdseCat(TMdseCat t) throws Exception ;

	public void updateMdseCat(TMdseCat t) throws Exception;

	public List<TMdseCat> mdseCatTree(Map map) throws Exception;

	// 通过名称判断是否存在，（不能重名）
	public TMdseCat existMdseCatWithCatName(String catName)throws Exception ;

	public JSONArray getMdseCatsByParentId()throws Exception ;

	public List<String> getMdseCatsByParentId(String parentId)throws Exception ;

}

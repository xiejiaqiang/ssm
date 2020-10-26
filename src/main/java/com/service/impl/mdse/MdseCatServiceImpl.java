package com.service.impl.mdse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.mdse.MdseCatMapper;
import com.entity.po.mdse.TMdseCat;
import com.entity.po.Example.mdse.TMdseCatExample;
import com.entity.po.mdse.TMdseInfo;
import com.entity.po.systemManage.Menu;
import com.service.mdse.IMdseCatService;
import com.util.StringUtil;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("mdseCatService")
public class MdseCatServiceImpl implements IMdseCatService {

	@Autowired
	MdseCatMapper mdseCatMapper;

	public List<TMdseCat> findMdseCat(TMdseCat mdseCat) throws Exception {
		return mdseCatMapper.select(mdseCat);
	};

	public Integer countMdseCat(TMdseCat mdseCat) throws Exception {
		return mdseCatMapper.selectCount(mdseCat);
	};

	public void addMdseCat(TMdseCat mdseCat) throws Exception {
		mdseCatMapper.insert(mdseCat);
	};

	public void updateMdseCat(TMdseCat mdseCat) throws Exception {
		mdseCatMapper.updateByPrimaryKeySelective(mdseCat);
	}

	@Override
	public TMdseCat existMdseCatWithCatName(String catName) throws Exception {
		TMdseCatExample example = new TMdseCatExample();
		example.createCriteria().andMdsecatnameEqualTo(catName);
		List<TMdseCat> list = mdseCatMapper.selectByExample(example);
		if (list != null && list.size()>0)
		return mdseCatMapper.selectByExample(example).get(0);
		return null;
	}

	@Override
	public JSONArray getMdseCatsByParentId() throws Exception {
		//查询所有分类
		List<TMdseCat> list = this.findMdseCat(new TMdseCat());
		Long[] ids = new Long[list.size()];
		for(int i=0;i<list.size();i++){
			ids[i] = list.get(i).getId();
		}
		return getMdseCatsByParentId("-1", ids);

	}

	@Override
	public List<String> getMdseCatsByParentId(String parentId) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add(parentId);
		return getMdseCatListByParentId(Long.parseLong(parentId), list);
	};

	private List<String> getMdseCatListByParentId(Long parentId, List<String> list)throws Exception {
		TMdseCat cat = new TMdseCat();
		cat.setParentId(parentId);
		List<TMdseCat> catList = this.findMdseCat(cat);
		if (catList == null || catList.size() == 0) {
			return list;
		} else {
			for (int i = 0; i < catList.size(); i++) {
				list.add(String.valueOf(catList.get(i).getId()));
				getMdseCatListByParentId(catList.get(i).getId(), list);
			}
		}
		return list;
	}
	private JSONArray getMdseCatsByParentId(String parentId,Long[] ids) throws Exception {
		JSONArray jsonArray = this.getMdseCatByParentId(parentId, ids);
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			TMdseCat cat = new TMdseCat();
			cat.setParentId((Long.parseLong(jsonObject.getString("id"))));
			List<TMdseCat> catList = this.findMdseCat(cat);
			if(catList == null || catList.size()==0){
				continue;
			}else{
				jsonObject.put("children", getMdseCatByParentId(jsonObject.getString("id"), ids));
			}
		}
		return jsonArray;
	};
	// 将所有的树菜单放入json数据中
	public JSONArray getMdseCatByParentId(String parentId,Long[] menuIds)throws Exception{
		JSONArray jsonArray=new JSONArray();
		Map map= new HashMap();
		map.put("parentId",Long.parseLong(parentId));
		map.put("mdseCatIds", menuIds);
		List<TMdseCat> list = this.mdseCatTree(map);
		for(TMdseCat cat : list){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", cat.getId());
			jsonObject.put("text", cat.getMdseCatName());
			jsonObject.put("no", cat.getMdseCatNo());
			jsonObject.put("state", cat.getState());
			jsonArray.add(jsonObject);
			TMdseCat c = new TMdseCat();
			c.setParentId(cat.getId());
			List<TMdseCat> catList = this.findMdseCat(c);
			if(catList == null || catList.size()==0){
				continue;
			}else{
				jsonObject.put("children", getMdseCatByParentId(cat.getId()+"", menuIds));
			}
		}
		return jsonArray;
	}


	public void deleteMdseCat(Long id) throws Exception {
		mdseCatMapper.deleteByPrimaryKey(id);
	};

	@SuppressWarnings("rawtypes")
	public List<TMdseCat> mdseCatTree(Map map) throws Exception {
		Long parentId = (Long) map.get("parentId");
		Long mdseCatIds[] = (Long[]) map.get("mdseCatIds");
		TMdseCatExample example = new TMdseCatExample();
		example.createCriteria().andIdIn(Arrays.asList(mdseCatIds)).andParentidEqualTo(parentId);
		return mdseCatMapper.selectByExample(example);
	}

	public TMdseCat findMdseCat(Long id) {
		return mdseCatMapper.selectByPrimaryKey(id);
	};
}

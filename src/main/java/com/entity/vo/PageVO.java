package com.entity.vo;

import java.util.HashMap;
import java.util.Map;

public class PageVO {
	 public PageVO()
	  {
	    this.map.put("data", "");
	    this.map.put("success", Boolean.valueOf(true));
	    this.map.put("message", "操作成功！");
	  }
	  
	  Map<String, Object> map = new HashMap<String, Object>();
	  
	  public Map<String, Object> getMap()
	  {
	    return this.map;
	  }
	  
	  public void setMap(Map<String, Object> map)
	  {
	    this.map = map;
	  }

	@Override
	public String toString() {
		return "PageVO{" +
				"map=" + map +
				'}';
	}
}

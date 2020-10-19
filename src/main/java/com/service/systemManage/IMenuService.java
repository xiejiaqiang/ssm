package com.service.systemManage;
import com.entity.po.systemManage.Menu;

import java.util.List;
import java.util.Map;

public interface IMenuService {

	public List<Menu> findMenu(Menu menu) throws Exception;

	public long countMenu(Menu menu) throws Exception;

	public void addMenu(Menu menu) throws Exception;

	public void updateMenu(Menu menu) throws Exception;

	public void deleteMenu(Integer menuid) throws Exception;

	@SuppressWarnings("rawtypes")
	public List<Menu> menuTree(Map map) throws Exception;
}

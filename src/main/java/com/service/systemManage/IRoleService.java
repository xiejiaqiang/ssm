package com.service.systemManage;
import com.entity.po.systemManage.Role;

import java.util.List;

public interface IRoleService {


	public Role findOneRole(Integer roleId) throws Exception;

	public List<Role> findRole(Role t) throws Exception ;

	public int countRole(Role t) throws Exception ;

	public void deleteRole(Integer roleid) throws Exception ;

	public void addRole(Role t) throws Exception ;

	public void updateRole(Role t) throws Exception;

	// 通过名称判断是否存在，（不能重名）
	public Role existRoleWithRoleName(String roleName)throws Exception ;

}

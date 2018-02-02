package com.service;
import com.entity.po.User;
import java.util.List;

public interface IUserService {
	// 查询所有
	public List<User> findUser(User t) throws Exception;

	// 数量
	public int countUser(User t) throws Exception;

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception;

	// 新增
	public void addUser(User t) throws Exception;

	// 修改
	public void updateUser(User t) throws Exception;

	// 删除
	public void deleteUser(Integer id) throws Exception;

	// 登录
	public User loginUser(User user) throws Exception;

	// 通过用户名判断是否存在，（新增时不能重名）
	public User existUserWithUserName(String userName) throws Exception;

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception;

}

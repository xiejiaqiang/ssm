package com.controller.systemManage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.util.ConfigUtil;
import com.constant.MmsConstats;
import com.entity.po.systemManage.Operation;
import com.entity.po.systemManage.Role;
import com.entity.po.systemManage.User;
import com.entity.vo.PageVO;
import com.util.StringUtil;
import com.util.WriterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.impl.systemManage.OperationServiceImpl;
import com.service.impl.systemManage.RoleServiceImpl;
import com.service.impl.systemManage.UserServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController extends LogController{
	static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private RoleServiceImpl roleService ;
	
	@Autowired
	private OperationServiceImpl operationService;
	
	
	@RequestMapping("userIndex")
	public String index(HttpServletRequest request,Integer menuid) throws Exception{
		List<Role> roleList = roleService.findRole(new Role());
		List<Operation> operationList = operationService.findOperationIdsByMenuid(menuid);
		request.setAttribute("operationList", operationList);
		request.setAttribute("roleList", roleList);
		return "systemManage/user";
	}
	
	
	@RequestMapping(value="userList",method=RequestMethod.POST)
	public void userList(HttpServletRequest request,HttpServletResponse response,String offset,String limit) throws Exception{
		try {
			User user = new User();
			String username = request.getParameter("username");
			String roleid = request.getParameter("roleid");
			String usertype = request.getParameter("usertype");
			String order = request.getParameter("order");
			String ordername = request.getParameter("ordername");
			if (StringUtil.isNotEmpty(username)) {
				user.setUsername(username);
			}
			if (StringUtil.isNotEmpty(roleid) && !"0".equals(roleid)) {
				user.setRoleid(Integer.parseInt(roleid));
			}
			if (StringUtil.isNotEmpty(usertype)) {
				user.setUsertype(usertype.getBytes()[0]);
			}
			
			Integer pageSize = StringUtil.isEmpty(limit)? ConfigUtil.getPageSize():Integer.parseInt(limit);
			Integer pageNum =  (Integer.parseInt(offset)/pageSize)+1;
			PageInfo<User> userList= userService.findUserPage(user,pageNum,pageSize,ordername,order);
			
			request.setAttribute("username", username);
			request.setAttribute("roleid", roleid);
			request.setAttribute("usertype", usertype);
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("total",userList.getTotal() );
			jsonObj.put("rows", userList.getList());
	        WriterUtil.write(response,jsonObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("用户展示错误",e);
			throw e;
		}
	}
	
	
	// 新增或修改
	@RequestMapping("reserveUser")
	public void reserveUser(HttpServletRequest request, User user, HttpServletResponse response){
		Integer userId = user.getUserid();
		JSONObject result=new JSONObject();
		try {
			if (userId != null) {   // userId不为空 说明是修改
				User userName = userService.existUserWithUserName(user.getUsername());
				if(userName == null || userName.getUserid().compareTo(userId)==0){
					user.setUserid(userId);
					userService.updateUser(user);
					result.put("success", true);
				}else{
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
				
			}else {   // 添加
				if(userService.existUserWithUserName(user.getUsername())==null){  // 没有重复可以添加
					userService.addUser(user);
					result.put("success", true);
				} else {
					result.put("success", true);
					result.put("errorMsg", "该用户名被使用");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("保存用户信息错误",e);
			result.put("success", true);
			result.put("errorMsg", "对不起，操作失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	
	@RequestMapping("deleteUser")
	public void delUser(HttpServletRequest request,HttpServletResponse response){
		JSONObject result=new JSONObject();
		try {
			String[] ids=request.getParameter("ids").split(",");
			for (String id : ids) {
				userService.deleteUser(Integer.parseInt(id));
			}
			result.put("success", true);
			result.put("delNums", ids.length);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("删除用户信息错误",e);
			result.put("errorMsg", "对不起，删除失败");
		}
		WriterUtil.write(response, result.toString());
	}
	
	@RequestMapping("editPassword")
	@ResponseBody
	public PageVO editPassword(HttpServletRequest request, HttpServletResponse response){
		PageVO pageVO = new PageVO();
		pageVO.getMap().put(MmsConstats.DATA, false);
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if(currentUser.getPassword().equals(oldpassword)){
			User user = new User();
			user.setUserid(currentUser.getUserid());
			user.setPassword(newpassword);
			try {
				userService.updateUser(user);
				currentUser.setPassword(newpassword);
				session.removeAttribute("currentUser"); 
				session.setAttribute("currentUser", currentUser);
				pageVO.getMap().put(MmsConstats.DATA, true);
			} catch (Exception e) {
				LOGGER.error("修改密码错误",e);
				pageVO.getMap().put(MmsConstats.MESSAGE, "系统异常,请联系管理员！.");
				pageVO.getMap().put(MmsConstats.SUCCESS, false);
			}
		}else{
			LOGGER.error(currentUser.getUsername()+"修改密码时原密码输入错误！");
			pageVO.getMap().put(MmsConstats.MESSAGE, "密码修改失败，原密码输入错误,请重新输入！.");
		}
		return  pageVO;
	}
}

package com.controller.systemManage;

import java.util.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.constant.MmsConstats;
import com.constant.ModuleTypeCode;
import com.entity.po.systemManage.Log;
import com.entity.po.systemManage.Menu;
import com.entity.po.systemManage.Role;
import com.entity.po.Token;
import com.entity.po.systemManage.User;
import com.entity.vo.PageVO;
import com.entity.vo.UpdateLogVO;
import com.util.*;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.impl.systemManage.LogServiceImpl;
import com.service.impl.systemManage.MenuServiceImpl;
import com.service.impl.systemManage.RoleServiceImpl;
import com.service.impl.TokenServiceImpl;
import com.service.impl.systemManage.UserServiceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录相关
 * @author xiejiaqiang
 */
@Controller
@SuppressWarnings("unchecked")
public class LoginController {

	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private MenuServiceImpl menuService;
	@Autowired
	private RoleServiceImpl roleService;
	@Autowired
	private LogServiceImpl logService;
	@Autowired
	private TokenServiceImpl tokenService;
	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 管理员登录
	 */
	@RequestMapping("login")
	@ResponseBody
	public PageVO login(HttpServletRequest request,HttpServletResponse response) {
		PageVO pageVO = new PageVO();
		try {
			HttpSession session = request.getSession();
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			String imageCode=request.getParameter("imageCode");
			String auto = request.getParameter("auto");
			request.setAttribute("username", userName);
			request.setAttribute("password", password);
			request.setAttribute("imageCode", imageCode);
			pageVO.getMap().put(MmsConstats.DATA, false);
			if(StringUtil.isEmpty(userName)||StringUtil.isEmpty(password)){
				LOGGER.error("前台验证拦截失效，账户或密码为空");
				pageVO.getMap().put(MmsConstats.MESSAGE, "账户或密码为空.");
				return pageVO;
			}
			if(StringUtil.isEmpty(imageCode)){
				LOGGER.error("前台验证拦截失效，验证码为空");
				pageVO.getMap().put(MmsConstats.MESSAGE, "验证码为空.");
				return pageVO;
			}
			if(!imageCode.toUpperCase().equals(session.getAttribute("sRand").toString().toUpperCase())){
				LOGGER.error("验证码错误，imageCode={}",imageCode);
				pageVO.getMap().put(MmsConstats.MESSAGE, "验证码错误.");
				return pageVO;
			}
			User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			User currentUser = userService.loginUser(user);
			if(currentUser ==null){
				LOGGER.info("数据库查询成功！用户名或密码验证失败={}","用户名或密码错误.");
				pageVO.getMap().put(MmsConstats.MESSAGE, "用户名或密码错误.");
				return pageVO;
			}else{
				LOGGER.info("数据库查询成功！用户名或密码验证成功！");
				// 加入登陆日志
				Log log = new Log();
				log.setUsername(userName);
				log.setCreatetime(new Date());
				log.setIp(IpUtil.getIpAddr(request));
				log.setOperation("登录");
				log.setModule(ModuleTypeCode.LOGIN_LOG_CODE.getCode());
				log.setContent("管理员登录操作");
				logService.insertLog(log);
				// 登录信息存入session
				Role role = roleService.findOneRole(currentUser.getRoleid());
				String roleName = role.getRolename();
				currentUser.setRoleName(roleName);
				session.setAttribute("currentUser", currentUser);  // 当前用户信息
				session.setAttribute("currentOperationIds", role.getOperationids());  // 当前用户所拥有的按钮权限
				//用户是不是登录判断
				session.setAttribute("loginFlag",true);
				// 勾选了两周内自动登录。
				if ("on".equals(auto)) {
					// 记住登录信息
					Token token = new Token();
					token.setUserid(currentUser.getUserid());
					String userAgent = StochasticUtil.getUUID();
					token.setUseragent(CodeUtil.getMd5(userAgent, 32));
					token.setCreatetime(new Date());
					Calendar cal = Calendar.getInstance();
					cal.add(cal.WEEK_OF_YEAR, 2);
					token.setExpiretime(cal.getTime());
					String t = CodeUtil.getMd5(currentUser.getUsername()+CodeUtil.getMd5(userAgent, 32), 32);
					token.setToken(t);
					tokenService.insertToken(token);

					// 设置cookie
					Cookie cookie = new Cookie("autoLogin",t);
					cookie.setMaxAge(3600*24*15);  // cookie时效15天
					response.addCookie(cookie);
				}
				pageVO.getMap().put(MmsConstats.DATA, true);

			}
		} catch (Exception e) {
			pageVO.getMap().put(MmsConstats.MESSAGE, "系统异常请联系管理员.");
			pageVO.getMap().put(MmsConstats.SUCCESS, false);
			LOGGER.error("!!!!!!!!!!!!!!!!!!!账号密码验证出现错误，错误信息：{},错误码：{}", e.getMessage(),e.getCause());
		}
		return pageVO;
	}
	//用户登录界面
	@RequestMapping(value = "userLogin")
	@ResponseBody
	public PageVO userLogin(User user, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		LOGGER.info(
				">>>>>>>>>>>>>>>>>>>>>进入用户名密码验证界面,username={}，password={}", user.getUsername(), user.getPassword());

		PageVO pageVO = new PageVO();
		response.setContentType("text/xml;charset=utf-8");
		try {
			User currentUser = userService.loginUser(user);
			if(currentUser ==null){
				pageVO.getMap().put(MmsConstats.MESSAGE, "用户名或密码错误.");
				pageVO.getMap().put(MmsConstats.DATA, false);
			}else{
				LOGGER.info("===========登陆成功==========");
				// 加入登陆日志
				Log log = new Log();
				log.setUsername(user.getUsername());
				log.setCreatetime(new Date());
				log.setIp(IpUtil.getIpAddr(request));
				log.setModule(ModuleTypeCode.LOGIN_LOG_CODE.getCode());
				log.setContent("普通用户登录操作");
				log.setOperation("登录");
				logService.insertLog(log);

				// 登录信息存入session
				Role role = roleService.findOneRole(currentUser.getRoleid());
				String roleName = role.getRolename();
				currentUser.setRoleName(roleName);
				session.setAttribute("currentUser", currentUser);  // 当前用户信息
				session.setAttribute("currentOperationIds", role.getOperationids());  // 当前用户所拥有的按钮权限
				//用户是不是登录判断
				session.setAttribute("loginFlag",true);
				pageVO.getMap().put(MmsConstats.DATA, true);
			}
			LOGGER.info(">>>>>>>>>>>>>>>>>>>>账号密码验证正常,验证结果为：{}", currentUser ==null?false:true);
		} catch (Exception e) {
			pageVO.getMap().put(MmsConstats.MESSAGE, "系统异常请联系管理员.");
			pageVO.getMap().put(MmsConstats.SUCCESS, false);
			LOGGER.error("!!!!!!!!!!!!!!!!!!!账号密码验证出现错误，错误信息：{},错误码：{}", e.getMessage(),e.getCause());
		}
		return pageVO;

	}

	//登陆失效页面
	@RequestMapping("lockscreen")
	public String lockscreen(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//先判断用户是否存在登录信息   存在：判断登录信息是否失效 失效进入登录页面 没失效进入非法页面  不存在:进入登录页面
		return "lockscreen";
	}

	// 进入系统主界面
	@RequestMapping("main")
	public String toMain(HttpServletRequest request,HttpServletResponse response) throws Exception{
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		if(currentUser == null ){
			return null;
		}
		getMenuTree("-1", currentUser,request,response);
		return "main";
	}
	// session失效页面
	@RequestMapping("remSession")
	@ResponseBody
	public PageVO remSession(String key,HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageVO pageVO =new PageVO();
		request.getSession().removeAttribute(key);
		pageVO.getMap().put(MmsConstats.DATA, true);
		return  pageVO;
	}

	// 进入系统主界面
	@RequestMapping("index")
	public String toIndex(HttpServletRequest request,HttpServletResponse response){
		Log log = new Log();
		log.setModule(ModuleTypeCode.SYSTEM_UPDATE_LOG_CODE.getCode());
		List<Log> logs = logService.sortQueryLog("createtime",MmsConstats.DESC, log);
		LOGGER.info("系统更新记录信息查询成功,size={}", logs.size());
		//copy系统更新记录信息到视图vo
		List<UpdateLogVO> updateLogs = CopyUtils.copyList(logs,UpdateLogVO.class);
		//遍历存放版本号，更新信息
		for (int i = 0, j = logs.size(); i<j; i++){
			updateLogs.get(i).setVersionsNo(logs.get(i).getIp());
			updateLogs.get(i).setId(logs.get(i).getLogid());
			updateLogs.get(i).setCreatetime( DateFormatUtils.format(logs.get(i).getCreatetime(),"yyyy.MM.dd"));
			if(!StringUtils.isEmpty(logs.get(i).getContent())){
				//更新信息存在则取出更新内容点存入视图vo
				String [] content = logs.get(i).getContent().split("\\|");
				List<String> list = new ArrayList<String>();
				for(String con:content){
					list.add(con);
				}
				updateLogs.get(i).setContent(list);
			}
		}
		LOGGER.debug("系统更新记录视图vo数据存放成功,updateLogs={}",updateLogs);
		request.setAttribute("logList", updateLogs);
		return "index";
	}

	// 加载最上级左菜单树
	public void getMenuTree(String parentId, User currentUser, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {

			Role role = roleService.findOneRole(currentUser.getRoleid());
			if(role != null && StringUtil.isNotEmpty(role.getMenuids())){
				String[] menuIds = role.getMenuids().split(",");
				Map map = new HashMap();
				map.put("parentId",parentId);
				map.put("menuIds", menuIds);
				JSONArray jsonArray = getMenusByParentId(parentId, menuIds);
				request.setAttribute("menuTree", jsonArray.get(0));
			}
		} catch (Exception e) {
			LOGGER.error("加载左菜单错误",e);
			throw e;
		}
	}


	// 递归加载所所有树菜单
	public JSONArray getMenusByParentId(String parentId,String[] menuIds)throws Exception{
		JSONArray jsonArray = this.getMenuByParentId(parentId,menuIds);
		for(int i=0;i<jsonArray.size();i++){
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if(!"isParent".equals(jsonObject.getString("state"))){
				continue;
			}else{
				jsonObject.put("children", getMenusByParentId(jsonObject.getString("id"),menuIds));
			}
		}
		return jsonArray;
	}


	// 将所有的树菜单放入json数据中
	public JSONArray getMenuByParentId(String parentId,String[] menuIds)throws Exception{
		JSONArray jsonArray=new JSONArray();
		Map map= new HashMap();
		map.put("parentId",Integer.parseInt(parentId));
		map.put("menuIds", menuIds);
		List<Menu> list = menuService.menuTree(map);
		//TODO
		Collections.sort(list, new Comparator<Menu>() {

			@Override
			public int compare(Menu o1, Menu o2) {
				int i = o1.getSeq() - o2.getSeq();
				return i;
			}
		});
		for(Menu menu : list){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", menu.getMenuid());
			jsonObject.put("text", menu.getMenuname());
			jsonObject.put("iconCls", menu.getIconcls());
			JSONObject attributeObject = new JSONObject();
			attributeObject.put("menuUrl", menu.getMenuurl());
			jsonObject.put("state", menu.getState());
			jsonObject.put("attributes", attributeObject);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}


	// 判断是不是有子孩子，人工结束递归树
	public boolean hasChildren(Integer parentId,String[] menuIds) throws Exception{
		boolean flag = false;
		try {
			Map map= new HashMap();
			map.put("parentId",parentId);
			map.put("menuIds", menuIds);
			List<Menu> list = menuService.menuTree(map);
			if (list == null || list.size()==0) {
				flag = false;
			}else {
				flag = true;
			}
		} catch (Exception e) {
			LOGGER.error("加载左菜单时判断是不是有子孩子错误",e);
			throw e;
		}
		return flag;
	}

	//安全退出
	@RequestMapping("logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws Exception{

		// 记录日志
		User currentUser = (User) request.getSession().getAttribute("currentUser");
		Log log = new Log();
		log.setUsername(currentUser.getUsername());
		log.setCreatetime(new Date());
		log.setOperation("退出");
		log.setModule(ModuleTypeCode.EXT_LOG_CODE.getCode());
		log.setContent("退出操作");
		log.setIp(IpUtil.getIpAddr(request));
		logService.insertLog(log);

		// 清空session
		request.getSession().invalidate();

		// 清空cookie
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = new Cookie(cookies[i].getName(), null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		response.sendRedirect("login.jsp");
	}



	/**
	 * 自动登录
	 * @param request
	 * @param response
	 */
	@RequestMapping("auto")
	public void autoLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null) {
        	for(int i=0; i<cookies.length; i++) {
           		Cookie cookie = cookies[i];
           		if("autoLogin".equals(cookie.getName())){
					  Map map = new HashMap();
					  map.put("token", cookie.getValue());
					  map.put("expireTime", new Date());
					  Token token = tokenService.findOneToken(map);
					  if (token == null) {
						  request.getRequestDispatcher("login.jsp").forward(request, response);
						  return;
					  } else {
						  	int userId = token.getUserid();
						  	User currentUser = userService.findOneUser(userId);
						  	Log log = new Log();
							log.setUsername(currentUser.getUsername());
							log.setCreatetime(new Date());
							log.setIp(IpUtil.getIpAddr(request));
							log.setOperation("登录");
							logService.insertLog(log);

							// 登录信息存入session
							Role role = roleService.findOneRole(currentUser.getRoleid());
							String roleName = role.getRolename();
							currentUser.setRoleName(roleName);
							HttpSession session = request.getSession();
							session.setAttribute("currentUser", currentUser);  // 当前用户信息
							session.setAttribute("currentOperationIds", role.getOperationids());  // 当前用户所拥有的按钮权限
						  //用户是不是登录判断
						  session.setAttribute("loginFlag",true);
						  // 跳转到主界面
							response.sendRedirect("main.htm");
							return;
					  }
           		}
        	}
    	}
    	request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
}

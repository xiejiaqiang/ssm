package com.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.po.systemManage.User;
import com.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static String username = "";
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 请求的路径
		String url = request.getServletPath().toString();
		HttpSession session = request.getSession();
		User currentUser = ((User) session.getAttribute("currentUser"));
		if (currentUser == null) {
			if (url.contains("login") || url.contains("auto")||url.contains("userLogin")||url.contains("lockscreen")) {
				return true;
			}else{
				Cookie[] cookies = request.getCookies();
				if(cookies != null){
					for(int i=0; i<cookies.length; i++) {
		           		Cookie cookie = cookies[i];
		           		if("autoLogin".equals(cookie.getName())){
		           			response.sendRedirect("auto.htm");
		        	        return true;
		           		}
	           		}
				}
			}
			response.sendRedirect(request.getContextPath()+"/lockscreen.htm?username="+username);
	        return true;
		}else {
			if (StringUtils.isEmpty(username)){
				username = currentUser.getUsername();
			}
		}
		return true;
	}
}

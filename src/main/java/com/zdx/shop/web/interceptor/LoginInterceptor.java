package com.zdx.shop.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		HttpSession session=request.getSession();
		if (url.indexOf("/log") >= 0||url.indexOf("/signUp")>=0) {
			return true;
		}
		else if (url.indexOf(".u")>=0) {
			Object user=session.getAttribute("USER_SESSION");
			if(user!=null)
				return true;
		}
		else if(url.indexOf(".s")>=0){
			Object shop=session.getAttribute("SHOP_SESSION");
			if(shop!=null)
				return true;
		}
		else
			return true;
		request.setAttribute("msg", "您还没有登陆，请先登陆！");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
				response);
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

}
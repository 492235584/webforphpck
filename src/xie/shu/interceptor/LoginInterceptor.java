package xie.shu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		Integer userId = (Integer)request.getSession().getAttribute("userId");
		//判断地址是否为login.jsp。是则直接放行
		String url = request.getRequestURI();
		if(url.indexOf("login.jsp")>=0 || url.indexOf("login.action")>=0){
			return true;
		}
		if(userId == null || userId ==0 ){
			response.sendRedirect("/webforphpck/login.jsp");
			return false;
		}
		return true;
	}

}

package com.facility.rest.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




@Component
public class SessionInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
	}


	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String token = request.getHeader(SessionListener.SESSION_USER_TOKEN);
		System.out.println("token: " + token);
		if(token != null && token.trim().length() > 0){
			if(SessionListener.getSession(token) != null){ 
				return true;
			}
		}
		
		response.setStatus(401);
		response.getWriter().write("Un Authorized");
		response.getWriter().flush();
		response.getWriter().close();
		return false;
	}
}

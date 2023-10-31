package com.mycom.more.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TestInterceptor implements HandlerInterceptor{
	// DispatcherServlet을 거치고 나가는 모든 것들에 대한 설정을 부여가능
	// Controller 이전에 수행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("TestInterceptor >>> " + request.getRequestURL());
		
		// #1 무조건 통과
		return true; // true 라면 통과, false 라면 막음
		
		// #2 선택적인 통과 -> 로그인 했으면 통과 -> 로그인 체크는 세션에 "login":"success" 이 있다면 통과
		
//		HttpSession session = request.getSession();
//		System.out.println(session.toString());
//		String login = (String) session.getAttribute("login");
//		System.out.println(login);
//		if("success".equals(login)) return true;
//		
//		response.sendRedirect(request.getContextPath() + "/login");		
//		return true;
	}
}

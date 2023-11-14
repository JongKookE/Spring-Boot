package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myboard.user.dto.UserDto;


// 클라이언트에 대한 응답을 성공/실패 <= json 문자열 "result": "login"
@Component
public class LoginInterceptor implements HandlerInterceptor{
	private final String jsonStr = "{\"result\": \"login\"}";
	// DispatcherServlet을 거치고 나가는 모든 것들에 대한 설정을 부여가능
	// Controller 이전에 수행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("TestInterceptor >>> " + request.getRequestURL());
		// JSP 없이 비동기 처리만!
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(userDto == null) {
			// 로그인이 필요하다는 응답
			response.getWriter().write(jsonStr);
			return false;
		}
		
		return true;
		
	}
}

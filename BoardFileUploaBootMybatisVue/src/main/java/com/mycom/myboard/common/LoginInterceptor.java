package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myboard.user.dto.UserDto;

// 클라이언트에 대한 응답을 성공/실패 <= json 문자열 "result":"login"
@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	private final String jsonStr = "{\"result\":\"login\"}";
	
	// dispatcherServlet을 통과하는 모든 요청들이 이것을 거침.
	// 컨트롤러 전에! (pre)	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // exclude 요청에는 아래 출력 X
        System.out.println("LoginInterceptor >>>> " + request.getRequestURI());
        System.out.println(handler);
        
        // CORS 에서  put, delete 등 오류 해결 코드
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("user");

        if( userDto == null ) {
            response.getWriter().write(jsonStr);            
            return false;
        }

        return true;
		
	}
}

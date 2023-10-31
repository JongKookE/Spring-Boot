package com.mycom.more.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// json 리턴으로 테스트
// jsp 사용 X

@RestController // @Controller + @ResponseBody
public class TestInterceptController {
	
	@GetMapping("/login")
	public String m1() {
		System.out.println("/login m1()");
		return "/login";
	}
	
	@GetMapping("/login/ok")
	public String m2(HttpSession session) {
		System.out.println("/login/ok m2()");
		session.setAttribute("login", "success");
		return "/login/ok";
	}
	
	@GetMapping("/logout") // 로그인 해야 접근 가능
	public String m3(HttpSession session) {
		System.out.println("/logout m3()");
		session.invalidate();
		return "/logout";
	}
	
	@GetMapping("/users") // 마이 페이지 -> 로그인 해야지 접근 가능
	public String m4() {
		System.out.println("/users m4()");
		return "/users";
	}
	
}

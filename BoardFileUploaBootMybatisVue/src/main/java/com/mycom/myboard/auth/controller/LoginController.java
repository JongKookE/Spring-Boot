package com.mycom.myboard.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.auth.service.LoginService;
import com.mycom.myboard.user.dto.UserDto;

import lombok.RequiredArgsConstructor;


// json result:success
// json result:fail

@RestController
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody UserDto dto, HttpSession session) {
		System.out.println(dto);
		UserDto userDto = loginService.login(dto);
		
		System.out.println(userDto);
		Map<String, String> map = new HashMap<>();
		if(userDto != null) {
			session.setAttribute("user", userDto); // 서버 용도
			
			// 클라이언트
			map.put("result", "success");
			map.put("userName", userDto.getUserName());
			map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
			return map;
		}
		map.put("result", "fail");
		return map;
		
	}
	
	@GetMapping("/logout")
	public Map<String, String> login(HttpSession session) {
		session.invalidate();
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
}

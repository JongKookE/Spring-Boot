package com.mycom.myboard.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.auth.service.LoginService;
import com.mycom.myboard.user.dto.UserDto;

// json result 전달
@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody UserDto dto, HttpSession session){
		UserDto userDto = loginService.login(dto);
		Map<String, String> map = new HashMap<>();
		// 성공
		if(userDto != null) {
			session.setAttribute("userDto", userDto);
			
			// 클라이언트에게 전달할 정보
			map.put("result", "success");
			map.put("userName", userDto.getUserName());
			map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
			return map;
		}
		map.put("result", "fail");
		return map;
	}
	
	@GetMapping("logout")
	public Map<String, String> logout(HttpSession session){
		session.invalidate();
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
}

package com.mycom.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StuController {
	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "mypage.html";
	}
	
	@GetMapping("/signup")
	@ResponseBody
	public String signup() {
		return "signup.html with @ResponseBody";
	}
	
	@GetMapping("/destinationDetail")
	public String destinationDetail() {
		return "destinationDetail.html";
	}
	
	@GetMapping("/destinationList")
	public String destinationList() {
		return "destinationList.html";
	}
	
	// login
	// mypage
	// signup
	// destinationDetail + maps
	// destinationList
	// 
}

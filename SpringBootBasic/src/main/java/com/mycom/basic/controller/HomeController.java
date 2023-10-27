package com.mycom.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // @Controller + @ResponseBody
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
}

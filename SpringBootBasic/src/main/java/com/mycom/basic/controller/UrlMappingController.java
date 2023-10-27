package com.mycom.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlMappingController {
	
	@RequestMapping("/hello")
	public String m0() {
		System.out.println("/hello");
		return "/hello";
	}
	
	@RequestMapping({"/hello1", "/hello2", "hello3"})
	public String m0_2() {
		System.out.println("/hello123");
		return "/hello123";
	}
	
	@RequestMapping("/hello/ssafy")
	public void m1() {
		System.out.println("/hello/ssafy");
	}
	
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public void m2() {
		System.out.println("/method GET");
	}
	
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public void m3() {
		System.out.println("/method POST");
	}
	
	// PUT + http:..../myapp/method/123
	// URL의 일부를 변수처럼 쓸 수 있는 기능 (좋을거같은디?)
	@RequestMapping(value = "/method/{num}/and/{str}", method = RequestMethod.PUT)
	public void m4(@PathVariable int num, @PathVariable String str) {
		System.out.println("/method PUT num: " + num);
		System.out.println("/method PUT str: " + str);
	}
	
	@GetMapping("/getmapping")
	public void m6() {
		System.out.println("/getmapping");
	}
	
	@PostMapping("/postmapping")
	public void m7() {
		System.out.println("/postmapping");
	}
	
	@RequestMapping("/subtest/*")
	public void m08() {
		System.out.println("/subtest/*");
	}
	
	@RequestMapping("/subtest/**")
	public void m09() {
		System.out.println("/subtest/**");
	}
	
}

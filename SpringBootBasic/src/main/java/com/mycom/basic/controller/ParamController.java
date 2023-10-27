package com.mycom.basic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.basic.dto.CarDto;

@RestController
public class ParamController {
	
	@GetMapping("/param1")
	public Map<String, String> m1(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		String seq = request.getParameter("seq");
		System.out.println(seq);	
		map.put("result", "success");
		return map;		
	}
	
	@PostMapping("/car")
	public Map<String, String> m2(CarDto dto){
		System.out.println(dto);
		System.out.println("Insert Success");
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		System.out.println(dto);
		return map;		
	}
	
	@PostMapping("/car2")
	public Map<String, String> m3(CarDto dto, HttpSession session){
		System.out.println(dto);
		System.out.println("Insert Success");
		session.setAttribute("carDto", dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;		
	}
	
	@PostMapping("/car3")
	public CarDto m4(HttpSession session){
		System.out.println("Insert Detail");
		CarDto dto = (CarDto) session.getAttribute("carDto");
		return dto;		
	}
	
}

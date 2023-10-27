package com.mycom.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.basic.dto.EmpDto;

@RestController
public class JsonController {
	
	@PostMapping("/emp")
	public Map<String, String> m1(@RequestBody EmpDto dto) {
		System.out.println(dto);		
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;		
	}
	
	@PostMapping("/empList")
	public Map<String, String> m2(@RequestBody List<EmpDto> empList) {
		for(EmpDto dto : empList) {
			System.out.println(dto);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;	
	}
			
	@GetMapping("/empDetail/{employeeId}")
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println(employeeId);
		return new EmpDto(3, "길동", "삼", "sam@gildong.com", "2023-03-03");
	}
	
	@GetMapping("/empList")
	public List<EmpDto> m4() {
		System.out.println("/empList");
		List<EmpDto> empList = new ArrayList<>();
		empList.add(new EmpDto(3, "길동", "삼", "sa@gildong.com", "2023-03-03"));
		empList.add(new EmpDto(1, "길동", "일", "il@gildong.com", "2023-03-03"));
		empList.add(new EmpDto(2, "길동", "이", "lee@gildong.com", "2023-03-03"));
		empList.add(new EmpDto(4, "길동", "사", "sam@gildong.com", "2023-03-03"));
		return empList;
	}
}

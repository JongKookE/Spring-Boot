package com.mycom.mydb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.EmpService;

// 사원 관리
@RestController
public class EmpController {
	private final EmpService empService;

	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}

	// 사원 상세
	@GetMapping("/empDetail/{employeeId}")
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println("사원 아이디는? : " + employeeId);
		return empService.empDetail(employeeId);
	}
	
	// 사원 리스트
	@GetMapping("/empList")
	public List<EmpDto> empList() {
		return empService.empList();
	}
	
	// 등록
	@PostMapping("/empInsert")
	public Map<String, String> empRegister(EmpDto dto) {
		int ret = empService.empInsert(dto);
		Map<String, String> map = new HashMap<String, String>();
		if(ret == 1) map.put("result", "success");
		else map.put("result", "fail");
		return map;
	}
	
	// 삭제
	@DeleteMapping("/empDelete/{employeeId}")
	public Map<String, String> empDelete(@PathVariable int employeeId) {
		int ret = empService.empDelete(employeeId);
		Map<String, String> map = new HashMap<String, String>();
		if(ret == 1) map.put("result", "success");
		else map.put("result", "fail");
		return map;
	}
	
	// 수정
	@PostMapping("/empUpdate")
	public Map<String, String> empUpdate(EmpDto dto) {
		int ret = empService.empUpdate(dto);
		Map<String, String> map = new HashMap<String, String>();
		if(ret == 1) map.put("result", "success");
		else map.put("result", "fail");
		return map;
	}
	
	// 사원 등록 JSON
	@PostMapping("/empInsertJSON")
	public Map<String, String> empRegisterJSON(@RequestBody EmpDto dto) {
		int ret = empService.empInsert(dto);
		Map<String, String> map = new HashMap<String, String>();
		if(ret == 1) map.put("result", "success");
		else map.put("result", "fail");
		return map;
	}
	
}

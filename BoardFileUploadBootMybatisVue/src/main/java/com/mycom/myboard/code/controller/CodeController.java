package com.mycom.myboard.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.code.dto.CodeDto;
import com.mycom.myboard.code.service.CodeService;

@RestController
public class CodeController {
	@Autowired
	CodeService codeService;
	
	@GetMapping("/codes")
	public List<CodeDto> codeList(String groupCode){
		return codeService.codeList(groupCode);
	}
	
}

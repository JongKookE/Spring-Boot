package com.mycom.myboard.code.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.code.dto.CodeDto;
import com.mycom.myboard.code.service.CodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/codes")
@RequiredArgsConstructor
public class CodeController {

	private final CodeService codeService;
	
	@GetMapping
	public List<CodeDto> codeList(String groupCode){
		return codeService.codeList(groupCode);
	}
	
}

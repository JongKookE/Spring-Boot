package com.ssafy.vue.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class MemberController {

	
	@ApiOperation(value = "회원 등록", notes = "회원을 등록합니다.")
	@PostMapping
	public ResponseEntity<?> registerUser(
			@RequestBody @ApiParam(value = "회원 정보.", required = true) String s) {
		return null;
	}
}

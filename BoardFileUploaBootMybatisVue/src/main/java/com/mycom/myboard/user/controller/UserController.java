package com.mycom.myboard.user.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.user.dto.UserDto;
import com.mycom.myboard.user.dto.UserResultDto;
import com.mycom.myboard.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	@PostMapping
	public UserResultDto register(@RequestBody UserDto userDto) {
		System.out.println(userDto);
		return userService.userRegister(userDto); 
	}
}

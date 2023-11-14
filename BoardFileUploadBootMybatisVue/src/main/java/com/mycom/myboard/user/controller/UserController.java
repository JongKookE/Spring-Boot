package com.mycom.myboard.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.user.dto.UserDto;
import com.mycom.myboard.user.dto.UserResultDto;
import com.mycom.myboard.user.service.UserService;

@RestController
public class UserController {
	
	
	private final UserService userService;	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	@PostMapping("/users")
	public UserResultDto register(@RequestBody UserDto userDto) {
		UserResultDto userResultDto = userService.userRegister(userDto);
		return userResultDto;
	}
}












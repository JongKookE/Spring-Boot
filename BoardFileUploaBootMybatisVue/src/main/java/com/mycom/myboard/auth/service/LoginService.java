package com.mycom.myboard.auth.service;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.user.dto.UserDto;

public interface LoginService {
	UserDto login(UserDto userDto);

}

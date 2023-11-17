package com.mycom.myboard.user.service;

import com.mycom.myboard.user.dto.UserDto;
import com.mycom.myboard.user.dto.UserResultDto;

public interface UserService {

	UserResultDto userRegister(UserDto userDto);
}

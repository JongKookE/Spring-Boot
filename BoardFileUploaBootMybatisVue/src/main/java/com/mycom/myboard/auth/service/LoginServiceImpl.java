package com.mycom.myboard.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycom.myboard.auth.dao.LoginDao;
import com.mycom.myboard.user.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

	private final LoginDao logindao;
	
	@Override
	public UserDto login(@RequestBody UserDto userDto) {
		UserDto dto = logindao.login(userDto.getUserEmail());
		if( dto != null && userDto.getUserPassword().equals(dto.getUserPassword())){
			userDto.setUserPassword(null);
			return dto;
		}
		return null;
	}

}

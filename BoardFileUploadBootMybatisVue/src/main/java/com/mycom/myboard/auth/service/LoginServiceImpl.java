package com.mycom.myboard.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.auth.dao.LoginDao;
import com.mycom.myboard.user.dto.UserDto;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDto login(UserDto dto) {
		UserDto userDto = loginDao.login(dto.getUserEmail());
		if(userDto != null && userDto.getUserPassword().equals(dto.getUserPassword())) {
			return userDto;
		}
		userDto.setUserPassword(null);
		return null;
	}

}

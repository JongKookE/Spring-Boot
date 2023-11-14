package com.mycom.myboard.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.user.dao.UserDao;
import com.mycom.myboard.user.dto.UserDto;
import com.mycom.myboard.user.dto.UserResultDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	@Override
	public UserResultDto userRegister(UserDto userDto) {
		UserResultDto userResultDto = new UserResultDto();
		if(userDao.userRegister(userDto) == 1) {
			userResultDto.setResult(SUCCESS);		
		}
		else {
			userResultDto.setResult(FAIL);
		}
		return userResultDto;
	}

}

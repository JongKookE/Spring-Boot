package com.mycom.myboard.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.user.dto.UserDto;

@Mapper
public interface UserDao {
	int userRegister(UserDto userDto);
}

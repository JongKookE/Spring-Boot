package com.mycom.myboard.auth.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.user.dto.UserDto;

@Mapper
public interface LoginDao {
	UserDto login(String userEmail);
}

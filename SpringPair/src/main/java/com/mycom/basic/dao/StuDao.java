package com.mycom.basic.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.basic.dto.StuDto;

@Mapper
public interface StuDao {
	StuDto stuDetail(int stuId);
}

package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface EmpDao {

	EmpDto empDetail(int employeeId); // 사원 상세
	List<EmpDto> empList(); // 사원 목록
	int empInsert(EmpDto dto); // 사원 등록
	int empUpdate(EmpDto dto); // 사원 수정
	int empDelete(int employeeId); // 사원 삭제
	
}

package com.mycom.mydb.dao;

import java.util.List;

import com.mycom.mydb.dto.EmpDto;

public interface EmpDao {

	EmpDto empDetail(int employeeId); // 사원 상세
	List<EmpDto> empList(); // 사원 목록
	int empInsert(EmpDto dto); // 사원 등록
	int empUpdate(EmpDto dto); // 사원 수정
	int empDelete(int employeeId); // 사원 삭제
	
}

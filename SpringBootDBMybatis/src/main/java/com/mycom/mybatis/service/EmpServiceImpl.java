package com.mycom.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.mybatis.dao.EmpDao;
import com.mycom.mybatis.dto.EmpDto;

@Service
public class EmpServiceImpl implements EmpService{

	EmpDao empDao;
	
	public EmpServiceImpl(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public EmpDto empDetail(int employeeId) {
		
		return empDao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		return empDao.empList();
	}

	@Override
	public int empInsert(EmpDto dto) {
		
		return empDao.empInsert(dto);
	}

	@Override
	public int empUpdate(EmpDto dto) {
		
		return empDao.empUpdate(dto);
	}

	@Override
	public int empDelete(int employeeId) {
		
		return empDao.empDelete(employeeId);
	}

}

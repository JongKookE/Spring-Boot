package com.mycom.mydb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mydb.dao.EmpDao;
import com.mycom.mydb.dto.EmpDto;

@Service
public class EmpServiceImpl implements EmpService{

	private final EmpDao empDao;
	
	public EmpServiceImpl(EmpDao empDao) {
		super();
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

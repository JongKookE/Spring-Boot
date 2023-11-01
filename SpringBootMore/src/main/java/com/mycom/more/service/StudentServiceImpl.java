package com.mycom.more.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.more.dao.StudentDao;
import com.mycom.more.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao dao;
	
	@Override
	public List<StudentDto> list() {
		return dao.list();
	}

	@Override
	public StudentDto detail(int studentId) {
		return dao.detail(studentId);
	}

	@Override
	@Transactional
	public int insert(StudentDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(StudentDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int studentId) {
		return dao.delete(studentId);
	}

	@Override
	public List<StudentDto> sort() {
		return dao.sort();
	}

	@Override
	public int randomViewsGenerator(int views) {
		int randomValue =(int) (Math.random() * 100) + 1;
		System.out.println(randomValue);
		return dao.randomViewsGenerator(views);
	}

}

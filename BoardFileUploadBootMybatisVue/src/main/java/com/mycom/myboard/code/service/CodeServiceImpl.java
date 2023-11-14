package com.mycom.myboard.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.code.dao.CodeDao;
import com.mycom.myboard.code.dto.CodeDto;
@Service
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	CodeDao codeDao;
	
	@Override
	public List<CodeDto> codeList(String groupCode) {
		return codeDao.codeList(groupCode);
	}

}

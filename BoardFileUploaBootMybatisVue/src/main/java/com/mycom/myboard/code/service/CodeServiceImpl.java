package com.mycom.myboard.code.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myboard.code.dao.CodeDao;
import com.mycom.myboard.code.dto.CodeDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService{

	private final CodeDao codeDao;
	
	@Override
	public List<CodeDto> codeList(String groupCode) {
		return codeDao.codeList(groupCode);
	}

}

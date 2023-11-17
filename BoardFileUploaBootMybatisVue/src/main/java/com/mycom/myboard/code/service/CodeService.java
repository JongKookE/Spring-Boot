package com.mycom.myboard.code.service;

import java.util.List;

import com.mycom.myboard.code.dto.CodeDto;

public interface CodeService {

	List<CodeDto> codeList(String groupCode);
}

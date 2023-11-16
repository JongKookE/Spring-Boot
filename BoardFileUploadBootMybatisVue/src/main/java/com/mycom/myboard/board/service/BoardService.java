package com.mycom.myboard.board.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;

public interface BoardService {
	BoardResultDto boardList(BoardParamDto dto);
	BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request);
}

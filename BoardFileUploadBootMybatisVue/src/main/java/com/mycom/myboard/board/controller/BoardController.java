package com.mycom.myboard.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;
import com.mycom.myboard.board.service.BoardService;
import com.mycom.myboard.user.dto.UserDto;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/boards")
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = boardService.boardList(boardParamDto);
		return boardResultDto;
	}
	
	@PostMapping("/boards")
	public BoardResultDto boardInsert (BoardDto boardDto, MultipartHttpServletRequest request) {
		// session 에서 userSeq 를 가져온다, 단 LoginInterceptor 가 앞단에서 비로그인사용자 처리를 해줘야한다.
		boardDto.setUserSeq(((UserDto) request.getSession().getAttribute("userDto")).getUserSeq());
		BoardResultDto boardResultDto = boardService.boardInsert(boardDto, request);
		return boardResultDto;
	}
}


package com.mycom.myboard.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardFileDto;
import com.mycom.myboard.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	List<BoardDto> boardList(BoardParamDto dto);
	int boardInsert(BoardDto dto);
	int boardFileInsert(BoardFileDto dto);
}

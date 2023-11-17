package com.mycom.myboard.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardFileDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;

public interface BoardService {

    BoardResultDto boardDetail(BoardParamDto boardParamDto);
    
    BoardResultDto boardDelete(int boardId);
    
    BoardResultDto boardUpdate(BoardDto dto, MultipartHttpServletRequest request);

    BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request);

    BoardResultDto boardList(BoardParamDto boardParamDto);
    //int boardListTotalCount();    
    BoardResultDto boardListSearchWord(BoardParamDto boardParamDto);
    //int boardListSearchWordTotalCount(boardParamDto boardParamDto);
}

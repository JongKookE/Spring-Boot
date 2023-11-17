package com.mycom.myboard.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardFileDto;
import com.mycom.myboard.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {

    BoardDto boardDetail(BoardParamDto boardParamDto);
    List<BoardFileDto> boardDetailFileList(int boardId);
   
   // map - Dto
    int boardUserReadCount(BoardParamDto boardParamDto); 
   
   // map - @param
    int boardUserReadInsert(
           @Param("boardId") int boardId, 
           @Param("userSeq") int userSeq ); 
   
    // 조회수 증가
    int boardReadCountUpdate(int boardId);
   
    
    // delete 관련!!
    // board 지우기
    int boardDelete(int boardId);
    // board 파일 지우기
    int boardFileDelete(int boardId);
    // 물리적인 file 경로 없애기
    List<String> boardFileUrlDeleteList(int boardId);
    // 조회수 지우기
    int boardReadCountDelete(int boardId);
   
    
    
    
    int boardInsert(BoardDto dto);
    int boardFileInsert(BoardFileDto dto);
   
    
    
    
    // list 조회, count 조회
    List<BoardDto> boardList(BoardParamDto boardParamDto);
    int boardListTotalCount();
   
    
    // 검색어로 검색하기, 검색어를 가진 총 건수
    List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
    int boardListSearchWordTotalCount(BoardParamDto boardParamDto);
   
    
    // 게시글 업데이트
    int boardUpdate(BoardDto dto);
}

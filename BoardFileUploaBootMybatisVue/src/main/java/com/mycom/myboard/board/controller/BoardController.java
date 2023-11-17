package com.mycom.myboard.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;
import com.mycom.myboard.board.service.BoardService;
import com.mycom.myboard.user.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
    @GetMapping(value="/boards")
    public BoardResultDto boardList(BoardParamDto boardParamDto){
        
        BoardResultDto boardResultDto;

        if( boardParamDto.getSearchWord().isEmpty() ) {
            boardResultDto = service.boardList(boardParamDto);
        }else {
            boardResultDto = service.boardListSearchWord(boardParamDto);
        }
        
        return boardResultDto;
    }

    
    @GetMapping(value="/boards/{boardId}")
    public BoardResultDto boardDetail(@PathVariable int boardId, HttpSession session){

        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setUserSeq( ((UserDto) session.getAttribute("user")).getUserSeq());
        boardParamDto.setBoardId(boardId);

        BoardResultDto boardResultDto = service.boardDetail(boardParamDto);
        // 게시글 작성자와 현 사용자가 동일
        if( ((UserDto) session.getAttribute("user")).getUserSeq() == boardResultDto.getDto().getUserSeq() ) {
            boardResultDto.getDto().setSameUser(true);
        }                
                
        return boardResultDto;     
    }
    
    @PostMapping(value="/boards")
    public BoardResultDto boardInsert(
            BoardDto boardDto, 
            MultipartHttpServletRequest request) {
        
        boardDto.setUserSeq( ((UserDto) request.getSession().getAttribute("user")).getUserSeq());
        BoardResultDto boardResultDto = service.boardInsert(boardDto, request);
        
        return boardResultDto;     
    }
    
    // PUT + multipart/form-data (X)
    // In RESTful,
    // PUT & DELETE methods are defined to be idempotent
    
    @PostMapping(value="/boards/{boardId}") 
    public BoardResultDto boardUpdate(
            BoardDto boardDto, 
            MultipartHttpServletRequest request){
        boardDto.setUserSeq( ((UserDto) request.getSession().getAttribute("user")).getUserSeq());
        BoardResultDto boardResultDto = service.boardUpdate(boardDto, request);

        return boardResultDto;        
    }
    
    @DeleteMapping(value="/boards/{boardId}") 
    public BoardResultDto boardDelete(@PathVariable(value="boardId") int boardId){
        BoardResultDto boardResultDto = service.boardDelete(boardId);
        
        return boardResultDto;         
    }

}

package com.mycom.myboard.board.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dao.BoardDao;
import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardFileDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDao;
	
	@Value("${app.fileupload.uploadPath}")
	String uploadPath;
	
	@Value("${app.fileupload.uploadFolder}")
	String uploadFolder;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;
	@Override
	public BoardResultDto boardList(BoardParamDto dto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			List<BoardDto> list = boardDao.boardList(dto);
			boardResultDto.setList(list);
			boardResultDto.setResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}
	
	@Override
	@Transactional
	public BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			boardDao.boardInsert(dto); // AI KEY
			List<MultipartFile> fileList =  request.getFiles("file");
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			if(! uploadDir.exists()) uploadDir.mkdir();
			
			for(MultipartFile part : fileList) {
				int boardId = dto.getBoardId();	
				// 물리적인 파일 저장
				String fileName = part.getOriginalFilename(); // 사용자가 첨부한 실제 파일 이름
				String extension = FilenameUtils.getExtension(fileName); // .jpg, .xlsm, .png
				UUID uuid = UUID.randomUUID();
				String savingFileName = uuid + "." + extension;
				
				File destFile = new File(uploadPath + File.separator + uploadFolder + File.pathSeparator + savingFileName);
				part.transferTo(destFile);
				
				// DB 파일 정보 저장
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(part.getSize());
				boardFileDto.setFileContentType(part.getContentType()	);
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName); 
				boardDao.boardFileInsert(boardFileDto);
			}
			boardResultDto.setResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

}

package com.mycom.myboard.board.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardDao dao;
	
	@Value("${app.fileupload.uploadPath}")
	String uploadPath;
	
	@Value("${app.fileupload.uploadFolder}")
	String uploadFolder;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
    @Override
    @Transactional
    public BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request) {
        
        BoardResultDto boardResultDto = new BoardResultDto();
        
        // transaction test #2 해결 
        // rollback 할 때 물리적으로 저장된 파일도 삭제하기 위해
        List<File> rollbackFileList = new ArrayList<>();
        
        try {
            dao.boardInsert(dto); // useGeneratedKeys="true" keyProperty="boardId"

//            // transaction test #1 
            // 테이블에만 insert 된 상태 => rollback 된다.
//            String s = null;
//            s.length();
            
            // transaction test #2 해결 
            List<MultipartFile> fileList = request.getFiles("file");
    
            File uploadDir = new File(uploadPath + File.separator + uploadFolder);
            if (!uploadDir.exists()) uploadDir.mkdir();
            
            for (MultipartFile part : fileList) {

                int boardId = dto.getBoardId();
                
                String fileName = part.getOriginalFilename();
                
                //Random File Id
                UUID uuid = UUID.randomUUID();
                
                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()
            
                String savingFileName = uuid + "." + extension;
            
                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                
                // transaction test #2 해결 
                // rollback 할 때 물리적으로 저장된 파일도 삭제하기 위해
                rollbackFileList.add(destFile);
                
                part.transferTo(destFile);
            
                // Table Insert
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setBoardId(boardId);
                boardFileDto.setFileName(fileName);
                boardFileDto.setFileSize(part.getSize());
                boardFileDto.setFileContentType(part.getContentType());
                String boardFileUrl = uploadFolder + "/" + savingFileName;
                boardFileDto.setFileUrl(boardFileUrl);

                // transaction test #2
                // 테이블에 insert + 물리적인 파일도 저장
                // transaction 만 처리하면 테이블과 다르게 물리적으로 저장된 파일은 남아 있다.
//                String s = null;
//                s.length();    
                
                dao.boardFileInsert(boardFileDto);
            }

            boardResultDto.setResult(SUCCESS);
        }catch(Exception e) {
            e.printStackTrace();

            // transaction test #2 해결 
            // 물리적인 파일도 삭제해 준다.
            for(File file : rollbackFileList) {    
                if(file.exists()) {
                    file.delete();
                }
            }
            
            boardResultDto.setResult(FAIL);
        }
        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto boardUpdate(BoardDto dto, MultipartHttpServletRequest request){
        
        BoardResultDto boardResultDto = new BoardResultDto();

        List<File> rollbackFileList = new ArrayList<>();
        
        try {
            dao.boardUpdate(dto);

            //
            List<MultipartFile> fileList = request.getFiles("file");
            
            File uploadDir = new File(uploadPath + File.separator + uploadFolder);
            if (!uploadDir.exists()) uploadDir.mkdir();
            
            List<String> fileUrlList = dao.boardFileUrlDeleteList(dto.getBoardId());    
            for(String fileUrl : fileUrlList) {    
                File file = new File(uploadPath + File.separator, fileUrl);
                if(file.exists()) {
                    file.delete();
                }
            }

            dao.boardFileDelete(dto.getBoardId());
            
            
            for (MultipartFile part : fileList) {
                int boardId = dto.getBoardId();
                
                String fileName = part.getOriginalFilename();
                
                //Random File Id
                UUID uuid = UUID.randomUUID();
                
                //file extension
                String extension = FilenameUtils.getExtension(fileName); // vs FilenameUtils.getBaseName()
            
                String savingFileName = uuid + "." + extension;
            
                File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
                
                rollbackFileList.add(destFile);

                part.transferTo(destFile);
            
                // Table Insert
                BoardFileDto boardFileDto = new BoardFileDto();
                boardFileDto.setBoardId(boardId);
                boardFileDto.setFileName(fileName);
                boardFileDto.setFileSize(part.getSize());
                boardFileDto.setFileContentType(part.getContentType());
                String boardFileUrl = uploadFolder + "/" + savingFileName;
                boardFileDto.setFileUrl(boardFileUrl);
                
                dao.boardFileInsert(boardFileDto);
            }

            boardResultDto.setResult(SUCCESS);
            
        }catch(Exception e) {
            e.printStackTrace();
            
            // 물리적인 파일도 삭제해 준다.
            for(File file : rollbackFileList) {    
                if(file.exists()) {
                    file.delete();
                }
            }
            
            boardResultDto.setResult(FAIL);
        }
        
        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto boardDelete(int boardId) {
        
        BoardResultDto boardResultDto = new BoardResultDto();
        
        try {
            // 테이블 -> 물리 파일 순서가 반대로 되면 삭제 성공했는데 테이블 오류나면 방법 X
            // 테이블 작업을 우선 수행
            dao.boardFileDelete(boardId);
            dao.boardReadCountDelete(boardId);
            dao.boardDelete(boardId);        
            boardResultDto.setResult(SUCCESS);
            
            // 그 다음 물리적인 파일 삭제 처리
            // 아래 작업이 오류 나면 테이블 rollback
            List<String> fileUrlList = dao.boardFileUrlDeleteList(boardId);
            for(String fileUrl : fileUrlList) {
                File file = new File(uploadPath + File.separator, fileUrl);                
                if(file.exists()) {
                    file.delete();
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        
        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto boardDetail(BoardParamDto boardParamDto) {
        
        BoardResultDto boardResultDto = new BoardResultDto();
        
        try {
            int userReadCnt = dao.boardUserReadCount(boardParamDto);
            if( userReadCnt == 0 ) {
                dao.boardUserReadInsert(boardParamDto.getBoardId(), boardParamDto.getUserSeq());
                dao.boardReadCountUpdate(boardParamDto.getBoardId());
            }
            
            BoardDto dto = dao.boardDetail(boardParamDto);
            List<BoardFileDto> fileList = dao.boardDetailFileList(dto.getBoardId());

            dto.setFileList(fileList);
            boardResultDto.setDto(dto);
            
            boardResultDto.setResult(SUCCESS);
            
        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        
        return boardResultDto;
    }

    @Override
    public BoardResultDto boardList(BoardParamDto boardParamDto) {
        
        BoardResultDto boardResultDto = new BoardResultDto();
        
        try {
            List<BoardDto> list = dao.boardList(boardParamDto);
            int count = dao.boardListTotalCount();            
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            boardResultDto.setResult(SUCCESS);
            
        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        
        return boardResultDto;
    }

    @Override
    public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
        
        BoardResultDto boardResultDto = new BoardResultDto();
        
        try {
            List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
            int count = dao.boardListSearchWordTotalCount(boardParamDto);
            
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            
            boardResultDto.setResult(SUCCESS);
        
        }catch(Exception e) {
            e.printStackTrace();
            boardResultDto.setResult(FAIL);
        }
        
        return boardResultDto;
    }

}

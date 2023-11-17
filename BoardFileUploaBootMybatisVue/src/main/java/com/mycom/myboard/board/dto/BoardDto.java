package com.mycom.myboard.board.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {
	
	private int boardId;
	private int userSeq;
	private String userName;
	private String userProfileImageUrl;
	private String title;
	private String content;
	private LocalDateTime regDt; // java8 버전에서 지원
	private int readCount;
	private boolean sameUser;
	
	// 첨부파일들
	private List<BoardFileDto> fileList;
	
	// regDt setter
	public void setRegDt(Date regDt) {
		// lombok + mybatis mapping 충돌 방지
		this.regDt = LocalDateTime.ofInstant(regDt.toInstant(), ZoneId.systemDefault());
	}
}

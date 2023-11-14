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

@Setter
@Getter
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
	private LocalDateTime regDt; // 자바 8버전 이상에서만 되기 때문에 롬복에서 기본으로 만드는 놈이랑 에러가 발생된다.
	private int readCount;
	private boolean sameUser;
	
	// 첨부파일들
	private List<BoardFileDto> fileList;
	
	public void setRefDt(Date regDt) {
		// lombok + mybatis mapping 충돌 방지
		this.regDt = LocalDateTime.ofInstant(regDt.toInstant(), ZoneId.systemDefault());
	}
	
}

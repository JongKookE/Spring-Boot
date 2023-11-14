package com.mycom.myboard.board.dto;

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

// BoardResultDto 에게 보내는 파라미터
// 클라이언트에게 받고 보내는 것의 일관성을 부여
public class BoardParamDto {
	private int limit;
	private int offset;
	private String searchWord;
	
	private int boardId;
	private int userSeq;
}

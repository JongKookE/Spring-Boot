package com.mycom.myboard.board.dto;

import java.time.LocalDateTime;
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
public class BoardResultDto {

	private int result;
	private BoardDto dto; // 상세 조건
	private List<BoardDto> list; // 목록 여러건
	private int count; // 총건수
}

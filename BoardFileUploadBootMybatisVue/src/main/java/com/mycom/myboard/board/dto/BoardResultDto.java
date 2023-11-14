package com.mycom.myboard.board.dto;

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

// 이걸 왜 만드는가??? 
// 작업을 수행한 후 클라이언트에게 보여줄 것에 대한 정의?

public class BoardResultDto {
	private int result;
	private BoardDto dto; // 1건에 대한 상세 데이터를 여기에 집어넣는다.
	private List<BoardDto> list; // 여러건의 목록
	private int count; // 총 건수
}

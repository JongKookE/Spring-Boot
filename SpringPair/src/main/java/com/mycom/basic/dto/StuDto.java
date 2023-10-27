package com.mycom.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class StuDto {
	private int studentId;
	private String studentName;
	private String email;
	private String phone;
	
	
}

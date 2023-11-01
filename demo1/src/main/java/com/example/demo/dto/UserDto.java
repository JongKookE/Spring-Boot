package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private int userId;
    private  String userName;
    private String userPassword;
    private String userEmail;
}

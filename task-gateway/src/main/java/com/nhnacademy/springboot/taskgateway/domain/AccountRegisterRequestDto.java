package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;

@Data
public class AccountRegisterRequestDto {
    private String id;
    private String password;
    private String email;
    private String authority;

    private AccountRegisterRequestDto(){}

    public static AccountRegisterRequestDto createMember(String id, String password, String email){
        AccountRegisterRequestDto requestDto = new AccountRegisterRequestDto();
        requestDto.setId(id);
        requestDto.setPassword(password);
        requestDto.setEmail(email);
        requestDto.setAuthority("ROLE_MEMBER");

        return requestDto;
    }

    public static AccountRegisterRequestDto createAdmin(String id, String password, String email){
        AccountRegisterRequestDto requestDto = new AccountRegisterRequestDto();
        requestDto.setId(id);
        requestDto.setPassword(password);
        requestDto.setEmail(email);
        requestDto.setAuthority("ROLE_ADMIN");

        return requestDto;
    }
}

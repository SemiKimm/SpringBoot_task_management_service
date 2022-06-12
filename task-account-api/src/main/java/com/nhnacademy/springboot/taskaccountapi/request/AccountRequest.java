package com.nhnacademy.springboot.taskaccountapi.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String id;
    private String password;
    private String email;
    private String authority;
}

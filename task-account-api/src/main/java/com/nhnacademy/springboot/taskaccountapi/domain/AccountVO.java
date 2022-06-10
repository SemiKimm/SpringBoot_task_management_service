package com.nhnacademy.springboot.taskaccountapi.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class AccountVO {
    String id;
    String password;
    String email;
    String authority;
    String state;
}

package com.nhnacademy.springboot.taskgateway.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class AccountVO {
    String id;
    String password;
    String email;
    String state;
    String authority;
}

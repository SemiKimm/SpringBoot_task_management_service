package com.nhnacademy.springboot.taskaccountapi.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountRequest {
    String id;
    String password;
    String email;
    String authority;
}

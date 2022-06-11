package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class AccountRegisterRequest {
    @NotBlank
    @Size(min = 1, max = 20)
    private String id;
    @NotBlank
    @Size(min = 8, max = 20)
    private String password;
    @NotBlank
    private String email;

    private String authority;
}

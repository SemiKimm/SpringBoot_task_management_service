package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ProjectRegisterRequest {
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;
    @Size(max = 300)
    private String explanation;
}

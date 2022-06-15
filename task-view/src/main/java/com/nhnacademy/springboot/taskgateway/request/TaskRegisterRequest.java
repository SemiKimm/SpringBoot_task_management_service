package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TaskRegisterRequest {
    @NotBlank
    @Size(max = 100)
    private String title;
    @Size(max = 1000)
    private String content;
}

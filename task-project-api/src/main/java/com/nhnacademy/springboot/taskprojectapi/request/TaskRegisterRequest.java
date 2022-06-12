package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class TaskRegisterRequest {
    private String title;
    private String content;
}

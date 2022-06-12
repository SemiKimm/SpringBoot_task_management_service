package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class ProjectRegisterRequest {
    private String name;
    private String explanation;
}

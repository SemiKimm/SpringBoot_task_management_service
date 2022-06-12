package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class ProjectModifyRequest {
    private String state;
    private String name;
    private String explanation;
}

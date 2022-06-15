package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;

@Data
public class ProjectDto {
    Integer no;
    String state;
    String name;
    String explanation;
}

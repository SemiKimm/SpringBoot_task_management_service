package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class TaskModifyRequest {
    private String title;
    private String content;
    private Integer milestoneNo;
}

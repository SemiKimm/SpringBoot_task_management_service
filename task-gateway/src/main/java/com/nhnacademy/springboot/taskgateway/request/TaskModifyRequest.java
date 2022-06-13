package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;

@Data
public class TaskModifyRequest {
    private String title;
    private String content;
    private Integer milestoneNo;
}

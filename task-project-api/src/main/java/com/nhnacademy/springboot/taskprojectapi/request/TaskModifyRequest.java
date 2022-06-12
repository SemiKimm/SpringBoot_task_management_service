package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class TaskModifyRequest {
    private String title;
    private String content;
    private Integer milestoneNo; // fixme : milestone 구현 다 한담에는 milestone 넘어오도록??
}

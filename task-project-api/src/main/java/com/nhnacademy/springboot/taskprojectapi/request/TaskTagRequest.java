package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class TaskTagRequest {
    private Integer taskNo;
    private Integer tagNo;
}

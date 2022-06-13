package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class CommentRegisterRequest {
    private String writerId;
    private String content;
}

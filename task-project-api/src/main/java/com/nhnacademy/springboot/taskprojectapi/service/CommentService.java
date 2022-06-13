package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Comment;
import com.nhnacademy.springboot.taskprojectapi.request.CommentRegisterRequest;

public interface CommentService {
    Comment register(Integer taskNo, CommentRegisterRequest commentRegisterRequest);
}

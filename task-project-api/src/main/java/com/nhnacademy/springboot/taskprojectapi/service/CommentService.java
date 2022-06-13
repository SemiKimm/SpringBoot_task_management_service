package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.CommentDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Comment;
import com.nhnacademy.springboot.taskprojectapi.request.CommentModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.CommentRegisterRequest;

import java.util.List;

public interface CommentService {
    Comment register(Integer taskNo, CommentRegisterRequest commentRegisterRequest);

    Integer modify(Integer commentNo, CommentModifyRequest commentModifyRequest);

    String deleteComment(Integer commentNo);

    List<CommentDto> getCommentDtoListBy(Integer taskNo);

    CommentDto getCommentDtoBy(Integer commentNo);
}

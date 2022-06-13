package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Comment;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.repository.CommentRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskRepository;
import com.nhnacademy.springboot.taskprojectapi.request.CommentModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.CommentRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    public Comment register(Integer taskNo, CommentRegisterRequest commentRegisterRequest) {
        Task task = taskRepository
                .findById(taskNo)
                .orElseThrow(() -> new IllegalStateException("not exist task : " + taskNo));

        Comment comment = Comment.create(commentRegisterRequest.getWriterId(),
                commentRegisterRequest.getContent(),
                task);

        return commentRepository.save(comment);
    }

    @Override
    public Integer modify(Integer commentNo, CommentModifyRequest commentModifyRequest) {
        if(!commentRepository.existsById(commentNo)){
            throw new IllegalStateException("not exist comment : " + commentNo);
        }
        return commentRepository.update(commentNo,
                commentModifyRequest.getContent(),
                LocalDateTime.now());
    }

    @Override
    public String deleteComment(Integer commentNo) {
        if(!commentRepository.existsById(commentNo)){
            throw new IllegalStateException("not exist comment : " + commentNo);
        }
        commentRepository.deleteById(commentNo);
        return "{\"result\":\"delete success\"}";
    }
}

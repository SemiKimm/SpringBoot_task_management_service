package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Comment;
import com.nhnacademy.springboot.taskprojectapi.request.CommentModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.CommentRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentRestController {
    private final CommentService commentService;

    @PostMapping("/register/{taskNo}")
    public Comment doRegister(@PathVariable("taskNo") Integer taskNo,
                              @RequestBody CommentRegisterRequest commentRegisterRequest){
        return commentService.register(taskNo, commentRegisterRequest);
    }

    @PutMapping("/modify/{commentNo}")
    public Integer doModify(@PathVariable("commentNo") Integer commentNo,
                            @RequestBody CommentModifyRequest commentModifyRequest){
        return commentService.modify(commentNo, commentModifyRequest);
    }
}

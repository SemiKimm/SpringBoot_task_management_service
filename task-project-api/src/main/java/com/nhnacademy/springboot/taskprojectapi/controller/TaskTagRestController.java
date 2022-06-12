package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.TaskTag;
import com.nhnacademy.springboot.taskprojectapi.request.TaskTagRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task/tag")
public class TaskTagRestController {
    private final TaskTagService taskTagService;

    @PostMapping("/register")
    public TaskTag doRegister(@RequestBody TaskTagRequest taskTagRequest){
        return taskTagService.register(taskTagRequest);
    }
}

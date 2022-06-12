package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.TaskTag;
import com.nhnacademy.springboot.taskprojectapi.request.TaskTagRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task/tag")
public class TaskTagRestController {
    private final TaskTagService taskTagService;

    @PostMapping("/register")
    public TaskTag doRegister(@RequestBody TaskTagRequest taskTagRequest){
        return taskTagService.register(taskTagRequest);
    }

    @DeleteMapping("/{taskNo}/{tagNo}")
    public String doDelete(@PathVariable("taskNo") Integer taskNo,
                           @PathVariable("tagNo") Integer tagNo){
        return taskTagService.deleteTaskTag(taskNo, tagNo);
    }
}

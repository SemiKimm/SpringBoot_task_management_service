package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.request.TaskRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskRestController {
    private final TaskService taskService;

    @PostMapping("/register/{projectNo}/{participantId}")
    public Task doRegister(@PathVariable("projectNo") Integer projectNo,
                           @PathVariable("participantId") String participantId,
                           @RequestBody TaskRegisterRequest taskRegisterRequest){
        return taskService.register(projectNo, participantId, taskRegisterRequest);
    }
}

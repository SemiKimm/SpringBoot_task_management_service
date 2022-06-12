package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.request.TaskModifyRequest;
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

    @PutMapping("/modify/{taskNo}")
    public Integer doModify(@PathVariable("taskNo") Integer taskNo,
                         @RequestBody TaskModifyRequest taskModifyRequest){
        return taskService.modify(taskNo, taskModifyRequest);
    }

    @DeleteMapping("{taskNo}")
    public String doDelete(@PathVariable("taskNo") Integer taskNo){ // fixme : 얘도 project 처럼 삭제될때 연관된 댓글들도 삭제 되야 되나..?
        return taskService.deleteTask(taskNo);
    }
}

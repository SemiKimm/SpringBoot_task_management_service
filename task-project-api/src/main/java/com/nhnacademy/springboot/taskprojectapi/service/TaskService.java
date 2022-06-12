package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.request.TaskModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.TaskRegisterRequest;

import java.util.List;

public interface TaskService {
    Task register(Integer projectNo, String participantId, TaskRegisterRequest taskRegisterRequest);

    Integer modify(Integer taskNo, TaskModifyRequest taskModifyRequest);

    String deleteTask(Integer taskNo);

    Task getTaskBy(Integer taskNo);

    List<TaskDto> getTaskDtoListBy(Integer projectNo);
}

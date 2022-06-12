package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.request.TaskRegisterRequest;

public interface TaskService {
    Task register(Integer projectNo, String participantId, TaskRegisterRequest taskRegisterRequest);
}

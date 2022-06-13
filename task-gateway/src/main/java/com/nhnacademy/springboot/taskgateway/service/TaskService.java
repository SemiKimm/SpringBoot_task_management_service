package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.TaskDetailDto;
import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTaskDtoList(Integer projectNo);

    void register(Integer projectNo, String accountId, TaskRegisterRequest taskRegisterRequest);

    TaskDetailDto getTaskDetailDto(Integer taskNo);
}

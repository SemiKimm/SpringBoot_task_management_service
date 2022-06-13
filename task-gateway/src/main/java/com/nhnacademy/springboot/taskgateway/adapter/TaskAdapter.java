package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.TaskDetailDto;
import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;

import java.util.List;
import java.util.Optional;

public interface TaskAdapter {
    List<TaskDto> findTaskDtoList(Integer projectNo);

    void create(Integer projectNo, String accountId, TaskRegisterRequest taskRegisterRequest);

    Optional<TaskDetailDto> findTaskDetailDto(Integer taskNo);
}

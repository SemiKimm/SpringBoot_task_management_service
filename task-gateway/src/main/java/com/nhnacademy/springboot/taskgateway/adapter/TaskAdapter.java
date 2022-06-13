package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;

import java.util.List;

public interface TaskAdapter {
    List<TaskDto> findTaskDtoList(Integer projectNo);

    void create(Integer projectNo, String accountId, TaskRegisterRequest taskRegisterRequest);
}

package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskTagDto;
import com.nhnacademy.springboot.taskprojectapi.entity.TaskTag;
import com.nhnacademy.springboot.taskprojectapi.request.TaskTagRequest;

import java.util.List;

public interface TaskTagService {
    TaskTag register(TaskTagRequest taskTagRequest);

    String deleteTaskTag(Integer taskNo, Integer tagNo);

    List<TaskTagDto> getTaskTagDtoListBy(Integer taskNo);
}

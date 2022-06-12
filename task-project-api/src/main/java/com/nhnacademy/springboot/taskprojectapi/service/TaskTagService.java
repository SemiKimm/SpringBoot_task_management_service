package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.TaskTag;
import com.nhnacademy.springboot.taskprojectapi.request.TaskTagRequest;

public interface TaskTagService {
    TaskTag register(TaskTagRequest taskTagRequest);
}

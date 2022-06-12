package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;

public interface ProjectService {
    Project register(ProjectRegisterRequest projectRegisterRequest);
}

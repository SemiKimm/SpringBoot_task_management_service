package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;

public interface ProjectService {
    Project register(ProjectRegisterRequest projectRegisterRequest);

    Integer modify(Integer projectNo, ProjectModifyRequest projectModifyRequest);

    String delete(Integer projectNo);
}

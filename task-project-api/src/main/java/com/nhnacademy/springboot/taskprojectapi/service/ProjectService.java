package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.ProjectDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;

import java.util.List;

public interface ProjectService {
    Project register(ProjectRegisterRequest projectRegisterRequest);

    Integer modify(Integer projectNo, ProjectModifyRequest projectModifyRequest);

    String delete(Integer projectNo);

    Project getProject(Integer projectNo);

    List<ProjectDto> getProjectDtoListBy(String accountId, String state);
}

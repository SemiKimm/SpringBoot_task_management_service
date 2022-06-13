package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskprojectapi.domain.ProjectDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project register(ProjectRegisterRequest projectRegisterRequest);

    Integer modify(Integer projectNo, ProjectModifyRequest projectModifyRequest);

    String delete(Integer projectNo);

    Optional<ProjectDto> getProject(Integer projectNo);

    List<ParticipantProjectDto> getProjectDtoListBy(String accountId, String state);
}

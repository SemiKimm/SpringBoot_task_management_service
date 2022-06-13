package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.domain.ProjectDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;

import java.util.List;
import java.util.Optional;

public interface ProjectAdapter {
    void createProject(String accountId, ProjectRegisterRequest projectRegisterRequest);

    Integer modifyProject(Integer projectNo, ProjectModifyRequest projectModifyRequest);

    List<ParticipantProjectDto> findProjectList(String accountId, String state);

    Optional<ProjectDto> findProject(Integer projectNo);
}

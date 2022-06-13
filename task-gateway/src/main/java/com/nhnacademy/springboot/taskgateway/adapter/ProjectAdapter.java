package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;

import java.util.List;

public interface ProjectAdapter {
    List<ParticipantProjectDto> findProjectList(String accountId, String state);

    void createProject(String accountId, ProjectRegisterRequest projectRegisterRequest);
}

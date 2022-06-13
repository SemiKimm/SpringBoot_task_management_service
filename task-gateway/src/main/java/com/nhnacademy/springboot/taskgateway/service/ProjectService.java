package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;

import java.util.List;

public interface ProjectService {
    List<ParticipantProjectDto> getProjectList(String accountId, String state);

    void register(String accountId, ProjectRegisterRequest projectRegisterRequest);
}

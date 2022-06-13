package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectAdapter projectAdapter;

    @Override
    public List<ParticipantProjectDto> getProjectList(String accountId, String state) {
        return projectAdapter.findProjectList(accountId, state);
    }

    @Override
    public void register(String accountId, ProjectRegisterRequest projectRegisterRequest) {
        projectAdapter.createProject(accountId, projectRegisterRequest);
    }
}

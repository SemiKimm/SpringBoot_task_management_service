package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ParticipantAdapter;
import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.domain.ProjectDto;
import com.nhnacademy.springboot.taskgateway.exception.NotExistProjectException;
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
    public void register(String accountId, ProjectRegisterRequest projectRegisterRequest) {
        projectAdapter.createProject(accountId, projectRegisterRequest);
    }

    @Override
    public List<ParticipantProjectDto> getProjectList(String accountId, String state) {
        return projectAdapter.findProjectList(accountId, state);
    }

    @Override
    public ProjectDto getProject(Integer projectNo) {
        return projectAdapter.findProject(projectNo).orElseThrow(NotExistProjectException::new);
    }
}

package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    @Override
    public Project register(ProjectRegisterRequest projectRegisterRequest) {
        Project project = Project.create(projectRegisterRequest.getName(),
                projectRegisterRequest.getExplanation());
        return projectRepository.save(project);
    }

    @Override
    public Integer modify(Integer projectNo, ProjectModifyRequest projectModifyRequest) {
        if(!projectRepository.existsById(projectNo)){
            throw new IllegalArgumentException("not exist project : " + projectNo);
        }
        return projectRepository.updateProjectInfo(projectNo,
                projectModifyRequest.getState(),
                projectModifyRequest.getName(),
                projectModifyRequest.getExplanation());
    }
}

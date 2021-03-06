package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskprojectapi.domain.ProjectDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public String delete(Integer projectNo) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalArgumentException("not exist project : " + projectNo));
        projectRepository.delete(project);

        return "{\"result\":\"delete success\"}";
    }

    @Override
    public Optional<ProjectDto> getProject(Integer projectNo) {
        return projectRepository
                .findProjectDtoByNo(projectNo);
    }

    @Override
    public List<ParticipantProjectDto> getProjectDtoListBy(String accountId, String state) {
        return projectRepository
                .findProjectDtoList(accountId, state);
    }
}

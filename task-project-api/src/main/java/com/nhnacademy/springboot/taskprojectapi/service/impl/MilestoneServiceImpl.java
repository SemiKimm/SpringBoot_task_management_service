package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.repository.MilestoneRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Milestone register(Integer projectNo, MilestoneRegisterRequest milestoneRegisterRequest) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalStateException("not exist project : " + projectNo));

        Milestone milestone = Milestone.create(milestoneRegisterRequest.getName(), project);

        if(Objects.nonNull(milestoneRegisterRequest.getStartDate()) &&
        Objects.nonNull(milestoneRegisterRequest.getFinishDate())){
            milestone.setStartDate(LocalDate.parse(milestoneRegisterRequest.getStartDate(), DateTimeFormatter.ofPattern("yyyyMMdd")));
            milestone.setFinishDate(LocalDate.parse(milestoneRegisterRequest.getFinishDate(), DateTimeFormatter.ofPattern("yyyyMMdd")));
        }

        return milestoneRepository.save(milestone);
    }
}

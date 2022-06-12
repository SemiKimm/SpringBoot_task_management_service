package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.repository.MilestoneRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRequest;
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
    public Milestone register(Integer projectNo, MilestoneRequest milestoneRequest) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalStateException("not exist project : " + projectNo));

        Milestone milestone = Milestone.create(milestoneRequest.getName(), project);

        if(Objects.nonNull(milestoneRequest.getStartDate()) &&
        Objects.nonNull(milestoneRequest.getFinishDate())){
            milestone.setStartDate(LocalDate.parse(milestoneRequest.getStartDate(), DateTimeFormatter.ofPattern("yyyyMMdd")));
            milestone.setFinishDate(LocalDate.parse(milestoneRequest.getFinishDate(), DateTimeFormatter.ofPattern("yyyyMMdd")));
        }

        return milestoneRepository.save(milestone);
    }
}

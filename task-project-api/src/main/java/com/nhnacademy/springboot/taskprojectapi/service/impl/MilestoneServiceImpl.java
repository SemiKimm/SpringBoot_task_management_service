package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.MilestoneDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.enumm.State;
import com.nhnacademy.springboot.taskprojectapi.repository.MilestoneRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskRepository;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRequest;
import com.nhnacademy.springboot.taskprojectapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

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

    @Override
    public Integer modify(Integer milestoneNo, MilestoneRequest milestoneRequest) {
        if(!milestoneRepository.existsById(milestoneNo)){
            throw new IllegalStateException("not exist milestone : " + milestoneNo);
        }

        LocalDate startDate = null;
        LocalDate finishDate = null;

        if(Objects.nonNull(milestoneRequest.getStartDate()) &&
                Objects.nonNull(milestoneRequest.getFinishDate())){
            startDate = LocalDate.parse(milestoneRequest.getStartDate(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            finishDate = LocalDate.parse(milestoneRequest.getFinishDate(), DateTimeFormatter.ofPattern("yyyyMMdd"));
        }
        return milestoneRepository.update(milestoneNo,
                milestoneRequest.getName(),
                startDate,
                finishDate);
    }

    @Override
    public Integer modifyState(Integer milestoneNo, String state) {
        if(!milestoneRepository.existsById(milestoneNo)){
            throw new IllegalStateException("not exist milestone : " + milestoneNo);
        }
        return milestoneRepository.updateState(milestoneNo, state);
    }

    @Transactional
    @Override
    public String deleteMilestone(Integer milestoneNo) {
        if(!milestoneRepository.existsById(milestoneNo)){
            throw new IllegalStateException("not exist milestone : " + milestoneNo);
        }
        Integer updateTaskCount = taskRepository.deleteMilestoneBy(milestoneNo);
        milestoneRepository.deleteById(milestoneNo);
        return "{\"result\":\"delete success\", \"deletedMilestoneTaskCount\":"+updateTaskCount+"}";
    }

    @Override
    public List<MilestoneDto> getMilestoneDtoListBy(Integer projectNo, String state) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalStateException("not exist project : " + projectNo));
        return milestoneRepository.findAllByProjectAndState(project, State.valueOf(state).getState());
    }

    @Override
    public Optional<MilestoneDto> getMileStoneDto(Integer milestoneNo) {
        return milestoneRepository.findMilestoneDto(milestoneNo);
    }
}

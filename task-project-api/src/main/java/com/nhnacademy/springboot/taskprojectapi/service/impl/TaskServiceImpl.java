package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskDetailDto;
import com.nhnacademy.springboot.taskprojectapi.domain.TaskDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
import com.nhnacademy.springboot.taskprojectapi.repository.MilestoneRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.ParticipantRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskRepository;
import com.nhnacademy.springboot.taskprojectapi.request.TaskModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.TaskRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ParticipantRepository participantRepository;
    private final ProjectRepository projectRepository;
    private final MilestoneRepository milestoneRepository;

    @Override
    public Task register(Integer projectNo, String participantId, TaskRegisterRequest taskRegisterRequest) {
        ParticipantPk participantPk = new ParticipantPk(participantId, projectNo);
        Participant registrant = participantRepository
                .findById(participantPk)
                .orElseThrow(() -> new IllegalStateException("not exist participant : " + participantId));

        Task task = Task.create(taskRegisterRequest.getTitle(), taskRegisterRequest.getContent(), registrant);
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public Integer modify(Integer taskNo, TaskModifyRequest taskModifyRequest) {
        if(!taskRepository.existsById(taskNo)){
            throw new IllegalStateException("not exist task : " + taskNo);
        }

        if(Objects.nonNull(taskModifyRequest.getMilestoneNo())){
            Milestone milestone = milestoneRepository
                    .findById(taskModifyRequest.getMilestoneNo())
                    .orElseThrow(() -> new IllegalStateException("not exist milestone"));
            return taskRepository.updateTaskWithMilestone(taskNo,
                    taskModifyRequest.getTitle(),
                    taskModifyRequest.getContent(),
                    milestone);
        }

        return taskRepository.updateTask(taskNo,
                    taskModifyRequest.getTitle(),
                    taskModifyRequest.getContent());
    }

    @Override
    public String deleteTask(Integer taskNo) {
        if(!taskRepository.existsById(taskNo)){
            throw new IllegalStateException("not exist task : " + taskNo);
        }
        taskRepository.deleteById(taskNo);
        return "{\"result\":\"delete success\"}";
    }

    @Override
    public Optional<TaskDetailDto> getTaskBy(Integer taskNo) {
        return taskRepository
                .findTaskDetailDtoBy(taskNo);
    }

    @Override
    public List<TaskDto> getTaskDtoListBy(Integer projectNo) {
        if(!projectRepository.existsById(projectNo)){
            throw new IllegalStateException("not exist project : " + projectNo);
        }
        return taskRepository.findTaskDtoListBy(projectNo);
    }
}

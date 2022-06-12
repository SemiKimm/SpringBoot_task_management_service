package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
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

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ParticipantRepository participantRepository;
    private final ProjectRepository projectRepository;

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
            //return taskRepository.updateTaskWithMilestone();
            // fixme : milestone 구현 한 담에 여기 수정하기 마일스톤 들어갈 수 있도록
            return 0;
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
    public Task getTaskBy(Integer taskNo) {
        return taskRepository
                .findById(taskNo)
                .orElseThrow(() -> new IllegalStateException("not exist task : " + taskNo));
    }

    @Override
    public List<TaskDto> getTaskDtoListBy(Integer projectNo) {
        if(!projectRepository.existsById(projectNo)){
            throw new IllegalStateException("not exist project : " + projectNo);
        }
        return taskRepository.findTaskDtoListBy(projectNo);
    }
}

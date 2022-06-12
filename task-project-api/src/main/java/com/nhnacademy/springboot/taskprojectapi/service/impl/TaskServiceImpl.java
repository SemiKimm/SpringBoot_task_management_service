package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
import com.nhnacademy.springboot.taskprojectapi.repository.ParticipantRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskRepository;
import com.nhnacademy.springboot.taskprojectapi.request.TaskRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ParticipantRepository participantRepository;

    @Override
    public Task register(Integer projectNo, String participantId, TaskRegisterRequest taskRegisterRequest) {
        ParticipantPk participantPk = new ParticipantPk(participantId, projectNo);
        Participant registrant = participantRepository
                .findById(participantPk)
                .orElseThrow(() -> new IllegalStateException("not exist participant : " + participantId));

        Task task = Task.create(taskRegisterRequest.getTitle(), taskRegisterRequest.getContent(), registrant);
        return taskRepository.saveAndFlush(task);
    }
}

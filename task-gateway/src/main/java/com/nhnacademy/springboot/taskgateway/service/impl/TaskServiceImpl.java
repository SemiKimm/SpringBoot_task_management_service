package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ParticipantAdapter;
import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.adapter.TaskAdapter;
import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskAdapter taskAdapter;
    private final ProjectAdapter projectAdapter;
    private final ParticipantAdapter participantAdapter;

    @Override
    public List<TaskDto> getTaskDtoList(Integer projectNo) {
        return taskAdapter.findTaskDtoList(projectNo);
    }

    @Override
    public void register(Integer projectNo, String accountId, TaskRegisterRequest taskRegisterRequest) {
        if(projectAdapter.findProject(projectNo).isEmpty()){
            throw new NotFoundException("project");
        }
        if(participantAdapter.getParticipantDto(projectNo, accountId).isEmpty()){
            throw new AccessDeniedException("invalid access : " + accountId);
        }
        taskAdapter.create(projectNo, accountId, taskRegisterRequest);
    }
}

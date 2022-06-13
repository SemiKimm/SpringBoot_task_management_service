package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;

import java.util.List;

public interface ProjectService {
    List<ParticipantProjectDto> getProjectList(String accountId, String state);
}

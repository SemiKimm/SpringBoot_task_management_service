package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ParticipantRegisterRequest;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {
    Participant registerMember(ParticipantRegisterRequest participantRegisterRequest);

    Participant registerAdmin(String registrantId, Project project);

    String deleteMember(Integer projectNo, String memberId);

    List<ParticipantDto> getParticipants(Integer projectNo);

    Boolean exists(Integer projectNo, String accountId);

    Optional<ParticipantDto> getParticipantDto(Integer projectNo, String accountId);
}

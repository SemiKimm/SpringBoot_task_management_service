package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ParticipantRegisterRequest;

import java.util.List;

public interface ParticipantService {
    Participant registerMember(ParticipantRegisterRequest participantRegisterRequest);

    Participant registerAdmin(String registrantId, Project project);

    String deleteMember(Integer projectNo, String memberId);

    List<ParticipantDto> getParticipants(Integer projectNo);

    Boolean exists(Integer projectNo, String memberId);
}

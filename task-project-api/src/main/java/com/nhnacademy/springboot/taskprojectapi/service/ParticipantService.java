package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ParticipantRegisterRequest;

public interface ParticipantService {
    Participant registerMember(ParticipantRegisterRequest participantRegisterRequest);

    Participant registerAdmin(String registrantId, Project project);

    String deleteMember(Integer projectNo, String memberId);
}

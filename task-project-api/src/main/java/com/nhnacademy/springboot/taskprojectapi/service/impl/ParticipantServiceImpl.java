package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
import com.nhnacademy.springboot.taskprojectapi.repository.ParticipantRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.request.ParticipantRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Participant registerMember(ParticipantRegisterRequest participantRegisterRequest) {
        Project project = projectRepository
                .findById(participantRegisterRequest.getProjectNo())
                .orElseThrow(() -> new IllegalArgumentException("not exist project : " + participantRegisterRequest.getProjectNo()));

        ParticipantPk pk = new ParticipantPk(participantRegisterRequest.getAccountId(),
                project.getNo());

        Participant member = Participant.createMember(pk);
        member.setProject(project);

        return participantRepository.saveAndFlush(member);
    }

    @Override
    public Participant registerAdmin(String registrantId, Project project) {
        ParticipantPk pk = new ParticipantPk(registrantId, project.getNo());

        Participant admin = Participant.createAdmin(pk);
        admin.setProject(project);

        return participantRepository.saveAndFlush(admin);
    }

    @Override
    public String deleteMember(Integer projectNo, String memberId) {
        ParticipantPk pk = new ParticipantPk(memberId, projectNo);
        Participant participant = participantRepository
                .findById(pk)
                .orElseThrow(() -> new IllegalStateException("not exist participant : " + memberId));
        participantRepository.delete(participant);
        return "{\"result\":\"delete success\"}";
    }

    @Override
    public List<ParticipantDto> getParticipants(Integer projectNo) {
        if(!projectRepository.existsById(projectNo)){
            throw new IllegalArgumentException("not exist project : " + projectNo);
        }
        return participantRepository.findParticipantsBy(projectNo);
    }

    @Override
    public Boolean exists(Integer projectNo, String accountId) {
        if(!projectRepository.existsById(projectNo)){
            throw new IllegalArgumentException("not exist project : " + projectNo);
        }
        ParticipantPk pk = new ParticipantPk(accountId, projectNo);
        return participantRepository.existsById(pk);
    }
}

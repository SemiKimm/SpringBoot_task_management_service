package com.nhnacademy.springboot.taskprojectapi.repository.custom.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.entity.QParticipant;
import com.nhnacademy.springboot.taskprojectapi.repository.custom.ProjectRepositoryCustom;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ProjectRepositoryImpl extends QuerydslRepositorySupport implements ProjectRepositoryCustom {

    public ProjectRepositoryImpl() {
        super(Project.class);
    }

    @Override
    public List<ParticipantProjectDto> findProjectDtoList(String accountId, String state) {
        QParticipant qParticipant = QParticipant.participant;

        return from(qParticipant)
                .innerJoin(qParticipant.project)
                .where(qParticipant.project.state.eq(state))
                .where(qParticipant.pk.participantId.eq(accountId))
                .select(Projections.bean(ParticipantProjectDto.class,
                        qParticipant.project.no,
                        qParticipant.project.name,
                        qParticipant.authority))
                .fetch();
    }
}

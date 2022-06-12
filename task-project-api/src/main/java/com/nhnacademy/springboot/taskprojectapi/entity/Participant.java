package com.nhnacademy.springboot.taskprojectapi.entity;

import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_project_participants")
public class Participant {
    @EmbeddedId
    private ParticipantPk pk;
    @Column(name = "participant_authority", nullable = false)
    private String authority;

    @MapsId("projectNo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_no", nullable = false)
    private Project project;
}

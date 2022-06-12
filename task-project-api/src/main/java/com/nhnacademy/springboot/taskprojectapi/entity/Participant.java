package com.nhnacademy.springboot.taskprojectapi.entity;

import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
import com.nhnacademy.springboot.taskprojectapi.enumm.Authority;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_no", nullable = false)
    private Project project;

    public static Participant createMember(ParticipantPk participantPk){
        Participant member = new Participant();
        member.setPk(participantPk);
        member.setAuthority(Authority.MEMBER.getAuthority());

        return member;
    }

    public static Participant createAdmin(ParticipantPk participantPk){
        Participant admin = new Participant();
        admin.setPk(participantPk);
        admin.setAuthority(Authority.ADMIN.getAuthority());

        return admin;
    }
}

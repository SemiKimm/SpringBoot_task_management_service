package com.nhnacademy.springboot.taskprojectapi.domain;

public interface ParticipantDto {
    ParticipantId getPk();
    String getAuthority();

    interface ParticipantId{
        String getParticipantId();
    }
}

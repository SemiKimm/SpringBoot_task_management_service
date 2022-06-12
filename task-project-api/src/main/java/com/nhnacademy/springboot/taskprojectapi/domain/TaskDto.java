package com.nhnacademy.springboot.taskprojectapi.domain;

public interface TaskDto {
    Integer getNo();
    String getTitle();
    RegistrantId getRegistrant();

    interface RegistrantId{
        ParticipantDto.ParticipantId getPk();
    }
}

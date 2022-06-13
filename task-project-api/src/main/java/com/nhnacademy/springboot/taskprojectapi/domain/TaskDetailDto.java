package com.nhnacademy.springboot.taskprojectapi.domain;

import java.time.LocalDateTime;

public interface TaskDetailDto {
    Integer getNo();
    String getTitle();
    String getContent();
    LocalDateTime getCreateDateTime();
    TaskDto.RegistrantId getRegistrant();
    MilestoneDto getMilestone();

    interface RegistrantId{
        ParticipantDto.ParticipantId getPk();
    }
}

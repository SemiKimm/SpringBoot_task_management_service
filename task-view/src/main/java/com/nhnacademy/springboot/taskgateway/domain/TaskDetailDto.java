package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class TaskDetailDto {
    private Integer no;
    private String title;
    private String content;
    private LocalDateTime createDateTime;
    private TaskDto.RegistrantId registrant;
    private MilestoneDto milestone;

    @Data
    @NoArgsConstructor
    public static class RegistrantId{
        ParticipantDto.ParticipantId pk;
    }
}

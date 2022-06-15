package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TaskDto {
    private Integer no;
    private String title;
    private RegistrantId registrant;

    @Data
    @NoArgsConstructor
    public static class RegistrantId{
        ParticipantDto.ParticipantId pk;
    }
}

package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;

@Data
public class TaskDto {
    private Integer no;
    private String title;
    private RegistrantId registrant;

    @Data
    public class RegistrantId{
        ParticipantDto.ParticipantId pk;
    }
}

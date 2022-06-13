package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;

@Data
public class ParticipantDto {
    @Data
    public class ParticipantId{
        private String participantId;
    }
    private ParticipantId pk;
    private String authority;
}

package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ParticipantDto {
    @Data
    @NoArgsConstructor
    public static class ParticipantId{
        private String participantId;
    }
    private ParticipantId pk;
    private String authority;
}

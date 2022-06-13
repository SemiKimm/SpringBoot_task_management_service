package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;

@Data
public class ParticipantDto {
    @Data
    class ParticipantId{
        private String participantId;
    }
    private String authority;
}

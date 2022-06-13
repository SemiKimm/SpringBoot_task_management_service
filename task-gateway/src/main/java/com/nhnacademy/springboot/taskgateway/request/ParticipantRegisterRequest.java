package com.nhnacademy.springboot.taskgateway.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ParticipantRegisterRequest {
    private String accountId;
    private Integer projectNo;
}

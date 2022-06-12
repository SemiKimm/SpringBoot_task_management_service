package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;

@Data
public class ParticipantRegisterRequest {
    private String accountId;
    private Integer projectNo;
}

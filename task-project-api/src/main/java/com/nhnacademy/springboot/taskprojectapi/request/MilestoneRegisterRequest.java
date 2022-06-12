package com.nhnacademy.springboot.taskprojectapi.request;

import lombok.Data;
@Data
public class MilestoneRegisterRequest {
    private String name;
    private String startDate;
    private String finishDate;
}

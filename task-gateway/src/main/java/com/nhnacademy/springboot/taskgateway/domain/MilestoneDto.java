package com.nhnacademy.springboot.taskgateway.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MilestoneDto {
    private Integer no;
    private String name;
    private LocalDate startDate;
    private LocalDate finishDate;
}

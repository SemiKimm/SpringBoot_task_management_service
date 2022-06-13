package com.nhnacademy.springboot.taskprojectapi.domain;

import java.time.LocalDate;

public interface MilestoneDto {
    Integer getNo();
    String getName();
    String getState();
    LocalDate getStartDate();
    LocalDate getFinishDate();
}

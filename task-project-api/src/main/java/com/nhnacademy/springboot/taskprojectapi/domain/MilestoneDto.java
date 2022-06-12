package com.nhnacademy.springboot.taskprojectapi.domain;

import java.time.LocalDate;

public interface MilestoneDto {
    Integer getNo();
    String getName();
    LocalDate getStartDate();
    LocalDate getFinishDate();
}

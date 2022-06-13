package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MilestoneRequest {
    @NotBlank
    @Size(max = 30)
    private String name;
    private String startDate;
    private String finishDate;
}

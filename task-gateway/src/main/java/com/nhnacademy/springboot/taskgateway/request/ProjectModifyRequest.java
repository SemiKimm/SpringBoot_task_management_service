package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProjectModifyRequest {
    private String state;
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;
    @Size(max = 300)
    private String explanation;
}

package com.nhnacademy.springboot.taskgateway.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TagRequest {
    @NotBlank
    @Size(max = 20)
    private String name;
}

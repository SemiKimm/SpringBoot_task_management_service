package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
}

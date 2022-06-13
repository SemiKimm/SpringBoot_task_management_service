package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TaskAdapter;
import com.nhnacademy.springboot.taskgateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskAdapter taskAdapter;
}

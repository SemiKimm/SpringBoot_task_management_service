package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TaskAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class TaskAdapterImpl implements TaskAdapter {
    private final RestTemplate restTemplate;
}

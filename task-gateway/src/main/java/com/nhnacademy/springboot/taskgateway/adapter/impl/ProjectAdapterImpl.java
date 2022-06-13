package com.nhnacademy.springboot.taskgateway.adapter.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class ProjectAdapterImpl {
    private final RestTemplate restTemplate;
}

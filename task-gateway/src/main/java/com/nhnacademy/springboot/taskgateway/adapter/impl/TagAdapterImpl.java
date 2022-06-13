package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TagAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class TagAdapterImpl implements TagAdapter {
    private final RestTemplate restTemplate;

}

package com.nhnacademy.springboot.taskgateway.adapter.impl;

import com.nhnacademy.springboot.taskgateway.adapter.AccountAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AccountAdapterImpl implements AccountAdapter {
    private final RestTemplate restTemplate;
}

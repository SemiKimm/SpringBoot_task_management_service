package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.AccountAdapter;
import com.nhnacademy.springboot.taskgateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountAdapter accountAdapter;
}

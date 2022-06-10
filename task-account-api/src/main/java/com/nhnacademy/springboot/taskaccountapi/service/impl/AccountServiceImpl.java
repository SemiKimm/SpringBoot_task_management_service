package com.nhnacademy.springboot.taskaccountapi.service.impl;

import com.nhnacademy.springboot.taskaccountapi.repository.AccountRepository;
import com.nhnacademy.springboot.taskaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
}

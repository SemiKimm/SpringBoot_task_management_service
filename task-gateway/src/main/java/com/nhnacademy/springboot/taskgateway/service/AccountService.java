package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.request.AccountRegisterRequest;

public interface AccountService {
    AccountVO register(AccountRegisterRequest request);
}

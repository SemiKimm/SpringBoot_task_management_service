package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.AccountDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.request.AccountRegisterRequest;

import java.util.List;

public interface AccountService {
    AccountVO register(AccountRegisterRequest request);

    List<AccountDto> getAccountDtoListByState(String state);
}

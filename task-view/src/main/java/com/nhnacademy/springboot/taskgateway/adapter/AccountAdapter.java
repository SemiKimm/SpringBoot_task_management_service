package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.AccountDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountRegisterRequestDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;

import java.util.List;

public interface AccountAdapter {
    AccountVO getAccountVOBy(String username);

    AccountVO create(AccountRegisterRequestDto account);

    boolean checkIdExists(String id);

    List<AccountDto> findAccountDtoListBy(String state);
}

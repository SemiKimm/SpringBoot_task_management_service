package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.AccountDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountRegisterRequestDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;

import java.util.List;
import java.util.Optional;

public interface AccountAdapter {
    AccountVO create(AccountRegisterRequestDto account);

    Optional<AccountVO> getAccountVOBy(String username);

    List<AccountDto> findAccountDtoListBy(String state);
}

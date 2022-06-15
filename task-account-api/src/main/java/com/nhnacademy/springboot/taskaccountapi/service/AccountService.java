package com.nhnacademy.springboot.taskaccountapi.service;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountDto;
import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    AccountVO register(AccountRequest accountRequest);

    Optional<AccountVO> getAccountVO(String id);

    List<AccountDto> getAccountDtoListBy(String state);

    String inactivate(String id);

    String delete(String id);
}

package com.nhnacademy.springboot.taskaccountapi.service;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountDto;
import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;

import java.util.List;

public interface AccountService {
    AccountVO register(AccountRequest accountRequest);

    String delete(String id);

    String inactivate(String id);

    AccountVO getAccountVO(String id);

    Boolean isExists(String id);

    List<AccountDto> getAccountDtoListBy(String state);
}

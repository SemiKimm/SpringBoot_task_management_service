package com.nhnacademy.springboot.taskaccountapi.service;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;

public interface AccountService {
    AccountVO register(AccountRequest accountRequest);

    String delete(String id);

    String inactivate(String id);

    AccountVO getAccountVO(String id);

    Boolean isExists(String id);
}

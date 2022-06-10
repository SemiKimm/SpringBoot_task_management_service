package com.nhnacademy.springboot.taskaccountapi.service.impl;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.entity.Account;
import com.nhnacademy.springboot.taskaccountapi.entity.Authority;
import com.nhnacademy.springboot.taskaccountapi.repository.AccountRepository;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;
import com.nhnacademy.springboot.taskaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public AccountVO register(AccountRequest accountRequest) {
        Account account = Account.create(accountRequest.getId(),
                accountRequest.getPassword(),
                accountRequest.getEmail());

        Authority authority = new Authority(accountRequest.getId(), accountRequest.getAuthority(), account);

        account.setAuthority(authority);
        accountRepository.saveAndFlush(account);

        return new AccountVO(account.getId(),
                account.getPassword(),
                account.getEmail(),
                authority.getAuthority(),
                account.getState());
    }

    @Override
    public String delete(String id) {
        if(!accountRepository.existsById(id)){
            throw new IllegalStateException("not exist account : " + id);
        }
        accountRepository.deleteAccountByState(id);
        return "{\"result\":\"success\"}";
    }
}

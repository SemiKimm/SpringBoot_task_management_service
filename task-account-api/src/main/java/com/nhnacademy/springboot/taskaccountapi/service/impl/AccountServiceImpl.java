package com.nhnacademy.springboot.taskaccountapi.service.impl;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.entity.Account;
import com.nhnacademy.springboot.taskaccountapi.entity.Authority;
import com.nhnacademy.springboot.taskaccountapi.enumm.State;
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
        accountRepository.updateAccountState(id, State.WITHDRAWAL.getState());
        return "{\"result\":\"delete success\"}";
    }

    @Override
    public String inactivate(String id) {
        if(isDeletedAccount(id)){
            throw new IllegalStateException("already deleted : " + id);
        }
        accountRepository.updateAccountState(id, State.DORMANCY.getState());
        return "{\"result\":\"inactivate success\"}";
    }

    private boolean isDeletedAccount(String id){
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("not exist account : " + id));
        return account.getState().equals(State.WITHDRAWAL.getState());
    }
}

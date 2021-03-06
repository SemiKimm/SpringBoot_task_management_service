package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.AccountAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountRegisterRequestDto;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import com.nhnacademy.springboot.taskgateway.request.AccountRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountAdapter accountAdapter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountVO register(AccountRegisterRequest request) {
        if(accountAdapter.getAccountVOBy(request.getId()).isPresent()){
            throw new IllegalStateException("Id is duplicate");
        }
        return accountAdapter.create(AccountRegisterRequestDto.createMember(request.getId(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail()));
    }

    @Override
    public List<AccountDto> getAccountDtoListByState(String state) {
        return accountAdapter.findAccountDtoListBy(state);
    }
}

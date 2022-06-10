package com.nhnacademy.springboot.taskaccountapi.controller;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.entity.Account;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;
import com.nhnacademy.springboot.taskaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountRestController {
    private final AccountService accountService;

    @PostMapping("/register")
    public AccountVO doRegister(@RequestBody AccountRequest accountRequest){
        return accountService.register(accountRequest);
    }
}

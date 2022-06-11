package com.nhnacademy.springboot.taskaccountapi.controller;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;
import com.nhnacademy.springboot.taskaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountRestController {
    private final AccountService accountService;

    @PostMapping("/register")
    public AccountVO doRegister(@RequestBody AccountRequest accountRequest){
        return accountService.register(accountRequest);
    }

    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable("id") String id){
        return accountService.delete(id);
    }

    @GetMapping("/inactivate/{id}")
    public String doInactivate(@PathVariable("id") String id){
        return accountService.inactivate(id);
    }
}

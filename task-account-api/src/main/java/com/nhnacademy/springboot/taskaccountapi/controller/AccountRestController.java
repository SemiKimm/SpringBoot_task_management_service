package com.nhnacademy.springboot.taskaccountapi.controller;

import com.nhnacademy.springboot.taskaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountRestController {
    private final AccountService accountService;
}

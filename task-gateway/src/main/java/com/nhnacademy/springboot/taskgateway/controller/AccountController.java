package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/account")
@RequiredArgsConstructor
public class AccountController {
    private final com.nhnacademy.springboot.taskgateway.service.AccountService AccountService;
}

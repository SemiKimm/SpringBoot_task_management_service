package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.request.AccountRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/register")
    public String registerForm(){
        return "auth/joinForm";
    }

    @PostMapping("/register")
    public String doRegister(@Validated AccountRegisterRequest request,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(); // fixme : 예외 처리 페이지 만들기
        }
        accountService.register(request);
        return "redirect:/";
    }
}

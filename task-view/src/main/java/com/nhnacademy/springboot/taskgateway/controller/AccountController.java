package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.AccountDto;
import com.nhnacademy.springboot.taskgateway.request.AccountRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ValidationException;
import java.util.List;

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
            throw new ValidationException(bindingResult.toString());
        }
        accountService.register(request);
        return "redirect:/";
    }

    @GetMapping("/list/{state}/{projectNo}")
    public String accountList(@PathVariable("state") String state,
                              @PathVariable("projectNo") Integer projectNo,
                              Model model){
        List<AccountDto> accountList = accountService.getAccountDtoListByState(state);
        model.addAttribute("accounts", accountList);
        model.addAttribute("projectNo", projectNo);

        return "participant/accountList";
    }
}

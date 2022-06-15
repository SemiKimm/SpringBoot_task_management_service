package com.nhnacademy.springboot.taskaccountapi.controller;

import com.nhnacademy.springboot.taskaccountapi.domain.AccountDto;
import com.nhnacademy.springboot.taskaccountapi.domain.AccountVO;
import com.nhnacademy.springboot.taskaccountapi.enumm.State;
import com.nhnacademy.springboot.taskaccountapi.request.AccountRequest;
import com.nhnacademy.springboot.taskaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountRestController {
    private final AccountService accountService;

    @PostMapping
    public AccountVO postAccount(@RequestBody AccountRequest accountRequest){
        return accountService.register(accountRequest);
    }

    @GetMapping("/{id}")
    public Optional<AccountVO> getAccount(@PathVariable("id") String id){
        return accountService.getAccountVO(id);
    }

    @GetMapping
    public List<AccountDto> getAccounts(@RequestParam("state") String state){
        return accountService.getAccountDtoListBy(State.valueOf(state).getState());
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

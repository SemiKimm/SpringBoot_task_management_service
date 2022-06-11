package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.AccountAdapter;
import com.nhnacademy.springboot.taskgateway.domain.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountAdapter accountAdapter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountVO accountVO = accountAdapter.getAccountVOBy(username); //fixme : api 에서 not exist 로 error 나면 여기는 Null 넘어오나..? 확인해보기
        if(!accountVO.getState().equals("가입")){
            throw new IllegalStateException("not valid state account : " + username);
        }
        return new User(accountVO.getId(), accountVO.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(accountVO.getAuthority())));
    }
}

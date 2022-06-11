package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.AccountVO;

public interface AccountAdapter {
    AccountVO getAccountVOBy(String username);
}

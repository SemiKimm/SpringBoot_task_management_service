package com.nhnacademy.springboot.taskprojectapi.enumm;

import lombok.Getter;

public enum Authority {
    MEMBER("멤버"),
    ADMIN("관리자");

    @Getter
    private final String authority;

    Authority(String authority){
        this.authority = authority;
    }
}

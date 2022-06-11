package com.nhnacademy.springboot.taskaccountapi.enumm;

import lombok.Getter;

public enum State {
    JOIN("가입"),
    WITHDRAWAL("탈퇴"),
    DORMANCY("휴면");

    @Getter
    final String state;
    State(String state){
        this.state = state;
    }
}

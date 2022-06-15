package com.nhnacademy.springboot.taskgateway.enumm;

import lombok.Getter;

public enum State {
    ACTIVE("활성"),
    INACTIVE("휴면"),
    FINISH("종료");

    @Getter
    private final String state;

    State(String state) {
        this.state = state;
    }
}

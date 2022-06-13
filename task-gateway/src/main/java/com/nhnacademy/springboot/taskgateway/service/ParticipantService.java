package com.nhnacademy.springboot.taskgateway.service;

public interface ParticipantService {
    boolean isAdmin(String accountId, Integer projectNo);
}

package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantDto;

import java.util.List;

public interface ParticipantService {
    boolean isAdmin(String accountId, Integer projectNo);

    List<ParticipantDto> getParticipantDtoList(Integer projectNo);

    void register(Integer projectNo, String accountId);
}

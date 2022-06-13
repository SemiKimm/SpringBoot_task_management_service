package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantDto;

import java.util.Optional;

public interface ParticipantAdapter {
    Optional<ParticipantDto> getParticipantDto(Integer projectNo, String accountId);
}

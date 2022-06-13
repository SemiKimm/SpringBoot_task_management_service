package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantDto;
import com.nhnacademy.springboot.taskgateway.request.ParticipantRegisterRequest;

import java.util.List;
import java.util.Optional;

public interface ParticipantAdapter {
    Optional<ParticipantDto> getParticipantDto(Integer projectNo, String accountId);

    List<ParticipantDto> getParticipantDtoList(Integer projectNo);

    Boolean isDuplicated(Integer projectNo, String accountId);

    void create(ParticipantRegisterRequest participantRegisterRequest);
}

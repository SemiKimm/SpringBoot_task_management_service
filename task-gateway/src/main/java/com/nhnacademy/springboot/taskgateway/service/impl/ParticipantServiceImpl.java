package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ParticipantAdapter;
import com.nhnacademy.springboot.taskgateway.domain.ParticipantDto;
import com.nhnacademy.springboot.taskgateway.enumm.Authority;
import com.nhnacademy.springboot.taskgateway.request.ParticipantRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantAdapter participantAdapter;

    @Override
    public boolean isAdmin(String accountId, Integer projectNo) {
        ParticipantDto participantDto = participantAdapter
                .getParticipantDto(projectNo, accountId)
                .orElseThrow(() -> new NotFoundException("participant"));

        return participantDto.getAuthority().equals(Authority.ADMIN.getAuthority());
    }

    @Override
    public List<ParticipantDto> getParticipantDtoList(Integer projectNo) {
        return participantAdapter.getParticipantDtoList(projectNo);
    }

    @Override
    public void register(Integer projectNo, String accountId) {
        if(participantAdapter.isDuplicated(projectNo, accountId)){
            throw new AlreadyExistsException("participant");
        }
        participantAdapter.create(new ParticipantRegisterRequest(accountId, projectNo));
    }
}

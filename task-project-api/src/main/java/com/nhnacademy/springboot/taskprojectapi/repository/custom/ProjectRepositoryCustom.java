package com.nhnacademy.springboot.taskprojectapi.repository.custom;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantProjectDto;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ProjectRepositoryCustom {
    List<ParticipantProjectDto> findProjectDtoList(String accountId, String state);
}

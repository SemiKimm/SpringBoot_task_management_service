package com.nhnacademy.springboot.taskprojectapi.repository.custom;

import com.nhnacademy.springboot.taskprojectapi.domain.ProjectDto;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface ProjectRepositoryCustom {
    List<ProjectDto> findProjectDtoList(String accountId, String state);
}

package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TagRepository;
import com.nhnacademy.springboot.taskprojectapi.request.TagRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Tag register(Integer projectNo, TagRequest tagRequest) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalStateException("not exist project : " + projectNo));

        Tag tag = Tag.create(tagRequest.getName(), project);

        return tagRepository.save(tag);
    }
}

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
    public Tag register(Integer projectNo, String name) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalStateException("not exist project : " + projectNo));

        Tag tag = Tag.create(name, project);

        return tagRepository.save(tag);
    }

    @Override
    public Integer modify(Integer tagNo, String name) {
        if(!tagRepository.existsById(tagNo)){
            throw new IllegalStateException("not exist tag : " + tagNo);
        }
        return tagRepository.update(tagNo, name);
    }

    @Override
    public String deleteTag(Integer tagNo) { // fixme : task tag 에 있는것도 삭제되도록 하기
        if(!tagRepository.existsById(tagNo)){
            throw new IllegalStateException("not exist tag : " + tagNo);
        }
        tagRepository.deleteById(tagNo);

        return "{\"result\":\"delete success\"}";
    }
}

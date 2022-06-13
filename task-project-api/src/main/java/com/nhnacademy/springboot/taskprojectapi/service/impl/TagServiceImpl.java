package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.domain.TagDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.repository.ProjectRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TagRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskTagRepository;
import com.nhnacademy.springboot.taskprojectapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;
    private final TaskTagRepository taskTagRepository;

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
    public String deleteTag(Integer tagNo) {
        if(!tagRepository.existsById(tagNo)){
            throw new IllegalStateException("not exist tag : " + tagNo);
        }
        Integer deletedTaskTagCount =  taskTagRepository.deleteByTag(tagNo);
        tagRepository.deleteById(tagNo);

        return "{\"result\":\"delete success\", \"deletedTaskTagCount\":"+deletedTaskTagCount+"}";
    }

    @Override
    public List<TagDto> getTagDtoListBy(Integer projectNo) {
        Project project = projectRepository
                .findById(projectNo)
                .orElseThrow(() -> new IllegalStateException("not exist project : " + projectNo));

        return tagRepository.findAllByProject(project);
    }

    @Override
    public Optional<TagDto> getTagDto(Integer tagNo) {
        return tagRepository.findTagDtoBy(tagNo);
    }
}

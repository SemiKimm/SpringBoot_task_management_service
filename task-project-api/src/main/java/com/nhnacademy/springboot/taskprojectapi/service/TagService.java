package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.domain.TagDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.request.TagRequest;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag register(Integer projectNo, String name);

    Integer modify(Integer tagNo, String name);

    String deleteTag(Integer tagNo);

    List<TagDto> getTagDtoListBy(Integer projectNo);

    Optional<TagDto> getTagDto(Integer tagNo);
}

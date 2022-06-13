package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;

import java.util.List;
import java.util.Optional;

public interface TagAdapter {
    List<TagDto> findTagDtoList(Integer projectNo);

    void create(Integer projectNo, TagRequest tagRequest);

    Optional<TagDto> findTagDto(Integer tagNo);

    Integer update(Integer tagNo, TagRequest tagRequest);
}

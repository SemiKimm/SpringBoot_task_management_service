package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;

import java.util.List;

public interface TagAdapter {
    List<TagDto> findTagDtoList(Integer projectNo);

    void create(Integer projectNo, TagRequest tagRequest);
}

package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;

import java.util.List;

public interface TagService {
    List<TagDto> getTagDtoList(Integer projectNo);

    void register(Integer projectNo, TagRequest tagRequest);
}

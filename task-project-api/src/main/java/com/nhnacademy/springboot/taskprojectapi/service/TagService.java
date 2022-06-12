package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.request.TagRequest;

public interface TagService {
    Tag register(Integer projectNo, String name);

    Integer modify(Integer tagNo, String name);
}

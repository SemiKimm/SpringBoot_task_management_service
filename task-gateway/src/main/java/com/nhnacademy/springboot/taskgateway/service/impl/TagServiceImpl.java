package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.TagAdapter;
import com.nhnacademy.springboot.taskgateway.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagAdapter tagAdapter;
}

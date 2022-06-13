package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.MilestoneAdapter;
import com.nhnacademy.springboot.taskgateway.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneAdapter milestoneAdapter;
}

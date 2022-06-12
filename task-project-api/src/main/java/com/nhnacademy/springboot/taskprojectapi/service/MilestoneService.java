package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRegisterRequest;

public interface MilestoneService {
    Milestone register(Integer projectNo, MilestoneRegisterRequest milestoneRegisterRequest);
}

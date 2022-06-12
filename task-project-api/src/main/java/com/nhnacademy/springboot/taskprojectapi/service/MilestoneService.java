package com.nhnacademy.springboot.taskprojectapi.service;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRequest;

public interface MilestoneService {
    Milestone register(Integer projectNo, MilestoneRequest milestoneRequest);

    Integer modify(Integer milestoneNo, MilestoneRequest milestoneRequest);

    Integer modifyState(Integer milestoneNo, String state);

    String deleteMilestone(Integer milestoneNo);
}

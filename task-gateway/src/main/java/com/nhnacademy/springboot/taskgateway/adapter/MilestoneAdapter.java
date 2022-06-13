package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;

import java.util.List;

public interface MilestoneAdapter {
    List<MilestoneDto> findMilestoneDtoList(Integer projectNo, String state);

    void create(Integer projectNo, MilestoneRequest milestoneRequest);
}

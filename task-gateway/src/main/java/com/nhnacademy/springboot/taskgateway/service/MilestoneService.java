package com.nhnacademy.springboot.taskgateway.service;

import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;

import java.util.List;

public interface MilestoneService {
    List<MilestoneDto> getMilestoneDtoList(Integer projectNo, String state);

    void register(Integer projectNo, MilestoneRequest milestoneRequest);
}

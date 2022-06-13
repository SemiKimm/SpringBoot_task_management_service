package com.nhnacademy.springboot.taskgateway.adapter;

import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;

import java.util.List;
import java.util.Optional;

public interface MilestoneAdapter {
    List<MilestoneDto> findMilestoneDtoList(Integer projectNo, String state);

    void create(Integer projectNo, MilestoneRequest milestoneRequest);

    void changeState(Integer milestoneNo, String state);

    Optional<MilestoneDto> findMileStoneDto(Integer milestoneNo);

    Integer update(Integer milestoneNo, MilestoneRequest milestoneRequest);

    String deleteByNo(Integer milestoneNo);
}

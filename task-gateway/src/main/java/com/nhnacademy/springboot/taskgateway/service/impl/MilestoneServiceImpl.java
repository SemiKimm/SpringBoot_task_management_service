package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.MilestoneAdapter;
import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.exception.NotExistProjectException;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;
import com.nhnacademy.springboot.taskgateway.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MilestoneServiceImpl implements MilestoneService {
    private final MilestoneAdapter milestoneAdapter;
    private final ProjectAdapter projectAdapter;
    @Override
    public List<MilestoneDto> getMilestoneDtoList(Integer projectNo, String state) {
        if(projectAdapter.findProject(projectNo).isEmpty()){
            throw new NotExistProjectException();
        }
        return milestoneAdapter.findMilestoneDtoList(projectNo, state);
    }

    @Override
    public void register(Integer projectNo, MilestoneRequest milestoneRequest) {
        if(projectAdapter.findProject(projectNo).isEmpty()){
            throw new NotExistProjectException();
        }
        if(milestoneRequest.getStartDate().isBlank()){
            milestoneRequest.setStartDate(null);
            milestoneRequest.setFinishDate(null);
        }else{
            milestoneRequest.setStartDate(LocalDate.parse(milestoneRequest.getStartDate()).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
            milestoneRequest.setFinishDate(LocalDate.parse(milestoneRequest.getFinishDate()).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }
        milestoneAdapter.create(projectNo, milestoneRequest);
    }
}

package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRequest;
import com.nhnacademy.springboot.taskprojectapi.service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/milestone")
public class MilestoneRestController {
    private final MilestoneService milestoneService;

    @PostMapping("/register/{projectNo}")
    public Milestone doRegister(@PathVariable("projectNo") Integer projectNo,
                                @RequestBody MilestoneRequest milestoneRequest){
        return milestoneService.register(projectNo, milestoneRequest);
    }

    @PutMapping("/modify/{milestoneNo}")
    public Integer doModify(@PathVariable("milestoneNo") Integer milestoneNo,
                            @RequestBody MilestoneRequest milestoneRequest){
        return milestoneService.modify(milestoneNo, milestoneRequest);
    }
}

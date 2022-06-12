package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.request.MilestoneRegisterRequest;
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
                                @RequestBody MilestoneRegisterRequest milestoneRegisterRequest){
        return milestoneService.register(projectNo, milestoneRegisterRequest);
    }
}

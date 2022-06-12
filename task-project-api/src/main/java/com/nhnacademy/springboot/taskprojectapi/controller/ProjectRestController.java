package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectRestController {
    private final ProjectService projectService;

    @PostMapping("/register")
    public Project doRegister(@RequestBody ProjectRegisterRequest projectRegisterRequest){
        return projectService.register(projectRegisterRequest);
    }

    @PutMapping("/{projectNo}/modify")
    public Integer doModify(@PathVariable("projectNo") Integer projectNo,
                            @RequestBody ProjectModifyRequest projectModifyRequest){
        return projectService.modify(projectNo, projectModifyRequest);
    }
}

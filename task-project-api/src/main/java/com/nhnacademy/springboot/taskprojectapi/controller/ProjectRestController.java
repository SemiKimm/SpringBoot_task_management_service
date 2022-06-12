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

    @DeleteMapping("/{projectNo}")
    public String doDelete(@PathVariable("projectNo") Integer projectNo){ //fixme : 삭제 될때 연관된 participants 있는지 확인해서 얘네도 다 삭제해줘야 하나??
        return projectService.delete(projectNo);
    }

    @GetMapping("/{projectNo}")
    public Project project(@PathVariable("projectNo") Integer projectNo){
        return projectService.getProject(projectNo);
    }
}

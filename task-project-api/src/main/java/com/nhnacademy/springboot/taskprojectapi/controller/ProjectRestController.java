package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskprojectapi.domain.ProjectDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskprojectapi.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskprojectapi.service.ParticipantService;
import com.nhnacademy.springboot.taskprojectapi.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectRestController {
    private final ProjectService projectService;
    private final ParticipantService participantService;
    @Transactional
    @PostMapping("/register/{registrantId}")
    public Project doRegister(@PathVariable("registrantId") String registrantId,
                              @RequestBody ProjectRegisterRequest projectRegisterRequest){
        Project project = projectService.register(projectRegisterRequest);
        participantService.registerAdmin(registrantId, project);
        return project;
    }

    @PutMapping("/{projectNo}/modify")
    public Integer doModify(@PathVariable("projectNo") Integer projectNo,
                            @RequestBody ProjectModifyRequest projectModifyRequest){
        return projectService.modify(projectNo, projectModifyRequest);
    }

    @DeleteMapping("/{projectNo}")
    public String doDelete(@PathVariable("projectNo") Integer projectNo){
        return projectService.delete(projectNo);
    }

    @GetMapping("/{projectNo}")
    public Optional<ProjectDto> project(@PathVariable("projectNo") Integer projectNo){
        return projectService.getProject(projectNo);
    }

    @GetMapping("/list/{accountId}/{state}")
    public List<ParticipantProjectDto> getProjectDtoList(@PathVariable("accountId") String accountId,
                                                         @PathVariable("state") String state){
        return projectService.getProjectDtoListBy(accountId, state);
    }
}

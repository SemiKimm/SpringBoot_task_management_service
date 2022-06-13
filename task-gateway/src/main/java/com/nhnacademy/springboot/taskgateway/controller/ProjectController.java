package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/list/{state}")
    public String projectList(@PathVariable("state") String state,
                              Principal principal,
                              Model model){
        List<ParticipantProjectDto> projects =  projectService
                .getProjectList(principal.getName(), state);
        model.addAttribute("projects", projects);
        return "project/projectList";
    }
}

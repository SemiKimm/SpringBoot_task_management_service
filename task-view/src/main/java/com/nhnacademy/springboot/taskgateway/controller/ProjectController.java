package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.ParticipantProjectDto;
import com.nhnacademy.springboot.taskgateway.domain.ProjectDto;
import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.enumm.State;
import com.nhnacademy.springboot.taskgateway.request.ProjectModifyRequest;
import com.nhnacademy.springboot.taskgateway.request.ProjectRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.ParticipantService;
import com.nhnacademy.springboot.taskgateway.service.ProjectService;
import com.nhnacademy.springboot.taskgateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ParticipantService participantService;
    private final TaskService taskService;

    @GetMapping("/list/{state}")
    public String projectList(@PathVariable("state") String state,
                              Principal principal,
                              Model model){
        List<ParticipantProjectDto> projects =  projectService
                .getProjectList(principal.getName(), State.valueOf(state).getState());
        model.addAttribute("projects", projects);
        return "project/projectList";
    }

    @GetMapping("/register")
    public String registerForm(){
        return "project/projectRegisterForm";
    }

    @PostMapping("/register")
    public String doRegister(@Validated ProjectRegisterRequest projectRegisterRequest,
                             BindingResult bindingResult,
                             Principal principal){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        projectService.register(principal.getName(), projectRegisterRequest);

        return "redirect:/project/list/"+ State.ACTIVE.name();
    }

    @GetMapping("/view/{projectNo}")
    public String projectView(@PathVariable("projectNo") Integer projectNo,
                              Model model){
        ProjectDto project = projectService.getProject(projectNo);
        List<TaskDto> tasks = taskService.getTaskDtoList(projectNo);
        model.addAttribute("project", project);
        model.addAttribute("tasks",tasks);

        return "project/projectView";
    }

    @GetMapping("/modify/{projectNo}")
    public String modifyForm(@PathVariable("projectNo") Integer projectNo,
                             Principal principal,
                             Model model){
        if(!participantService.isAdmin(principal.getName(), projectNo)){
            throw new AccessDeniedException("invalid authority");
        }
        ProjectDto projectDto = projectService.getProject(projectNo);
        List<State> states = List.of(State.ACTIVE, State.INACTIVE, State.FINISH);
        model.addAttribute("project", projectDto);
        model.addAttribute("states", states);

        return "project/projectModifyView";
    }

    @PostMapping("/modify/{projectNo}")
    public String doModify(@PathVariable("projectNo") Integer projectNo,
                           @Validated ProjectModifyRequest projectModifyRequest){
        projectService.modify(projectNo, projectModifyRequest);
        return "redirect:/project/view/"+projectNo;
    }
}

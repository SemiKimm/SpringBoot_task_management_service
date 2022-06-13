package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.domain.TaskDetailDto;
import com.nhnacademy.springboot.taskgateway.enumm.State;
import com.nhnacademy.springboot.taskgateway.request.TaskModifyRequest;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.MilestoneService;
import com.nhnacademy.springboot.taskgateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ValidationException;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final MilestoneService milestoneService;

    @GetMapping("/register/{projectNo}")
    public String registerForm(@PathVariable("projectNo") Integer projectNo,
                               Model model){
        model.addAttribute("projectNo", projectNo);
        return "task/taskRegisterForm";
    }

    @PostMapping("/register/{projectNo}")
    public String doRegister(@PathVariable("projectNo") Integer projectNo,
                             @Validated TaskRegisterRequest taskRegisterRequest,
                             Principal principal,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        taskService.register(projectNo, principal.getName(), taskRegisterRequest);

        return "redirect:/project/view/"+projectNo;
    }

    @GetMapping("/view/{taskNo}/{projectNo}")
    public String taskView(@PathVariable("taskNo") Integer taskNo,
                           @PathVariable("projectNo") Integer projectNo,
                           Model model){
        TaskDetailDto task = taskService.getTaskDetailDto(taskNo);

        model.addAttribute("task", task);
        model.addAttribute("projectNo", projectNo);
        return "task/taskView";
    }

    @GetMapping("/modify/{taskNo}/{projectNo}")
    public String modifyForm(@PathVariable("taskNo") Integer taskNo,
                             @PathVariable("projectNo") Integer projectNo,
                             Principal principal,
                             Model model){
        TaskDetailDto task = taskService.getTaskDetailDto(taskNo);
        if(!task.getRegistrant().getPk().getParticipantId().equals(principal.getName())){
            throw new AccessDeniedException("modify task");
        }
        List<MilestoneDto> milestones = milestoneService.getMilestoneDtoList(projectNo, State.ACTIVE.name());

        model.addAttribute("task", task);
        model.addAttribute("milestones", milestones);
        model.addAttribute("projectNo", projectNo);
        return "task/taskModifyForm";
    }

    @PostMapping("/modify/{taskNo}/{projectNo}")
    public String doModify(@PathVariable("taskNo") Integer taskNo,
                           @PathVariable("projectNo") Integer projectNo,
                           Principal principal,
                           TaskModifyRequest taskModifyRequest){
        taskService.modify(taskNo, taskModifyRequest, principal.getName());
        return "redirect:/task/view/"+taskNo+"/"+projectNo;
    }

}

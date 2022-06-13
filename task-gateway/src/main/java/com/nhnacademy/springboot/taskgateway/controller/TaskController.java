package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.TaskDetailDto;
import com.nhnacademy.springboot.taskgateway.domain.TaskDto;
import com.nhnacademy.springboot.taskgateway.request.TaskRegisterRequest;
import com.nhnacademy.springboot.taskgateway.service.TaskService;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

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
}

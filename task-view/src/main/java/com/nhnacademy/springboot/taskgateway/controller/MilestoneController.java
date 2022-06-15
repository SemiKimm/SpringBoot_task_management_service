package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.MilestoneDto;
import com.nhnacademy.springboot.taskgateway.request.MilestoneRequest;
import com.nhnacademy.springboot.taskgateway.service.MilestoneService;
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
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/milestone")
public class MilestoneController {
    private final MilestoneService milestoneService;

    @GetMapping("/list/{state}/{projectNo}")
    public String milestoneList(@PathVariable("state") String state,
                                @PathVariable("projectNo") Integer projectNo,
                                Model model){
        List<MilestoneDto> milestones = milestoneService.getMilestoneDtoList(projectNo, state);
        model.addAttribute("milestones", milestones);
        model.addAttribute("projectNo", projectNo);

        return "milestone/milestoneList";
    }

    @GetMapping("/register/{projectNo}")
    public String registerForm(@PathVariable("projectNo") Integer projectNo,
                               Model model){
        model.addAttribute("projectNo", projectNo);
        return "milestone/milestoneForm";
    }

    @PostMapping("/register/{projectNo}")
    public String doRegister(@PathVariable("projectNo") Integer projectNo,
                             @Validated MilestoneRequest milestoneRequest,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("milestone");
        }
        milestoneService.register(projectNo, milestoneRequest);
        return "redirect:/milestone/list/ACTIVE/" + projectNo;
    }

    @GetMapping("/modify/{milestoneNo}/{state}/{projectNo}")
    public String doModifyState(@PathVariable("milestoneNo") Integer milestoneNo,
                                @PathVariable("state") String state,
                                @PathVariable("projectNo") Integer projectNo){
        milestoneService.modifyState(milestoneNo, state);
        return "redirect:/milestone/list/ACTIVE/" + projectNo;
    }

    @GetMapping("/modify/{milestoneNo}/{projectNo}")
    public String modify(@PathVariable("milestoneNo") Integer milestoneNo,
                         @PathVariable("projectNo") Integer projectNo,
                         Model model){
        MilestoneDto milestone = milestoneService.getMilestoneDto(milestoneNo);
        model.addAttribute("milestone", milestone);
        model.addAttribute("projectNo", projectNo);
        return "milestone/milestoneModifyForm";
    }

    @PostMapping("/modify/{milestoneNo}/{projectNo}")
    public String doModify(@PathVariable("milestoneNo") Integer milestoneNo,
                           @PathVariable("projectNo") Integer projectNo,
                           @Validated MilestoneRequest milestoneRequest,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("milestone");
        }
        milestoneService.modify(milestoneNo, milestoneRequest);
        return "redirect:/milestone/list/ACTIVE/" + projectNo;
    }

    @GetMapping("/delete/{milestoneNo}/{projectNo}")
    public String doDelete(@PathVariable("milestoneNo") Integer milestoneNo,
                           @PathVariable("projectNo") Integer projectNo){
        milestoneService.delete(milestoneNo);
        return "redirect:/milestone/list/ACTIVE/" + projectNo;
    }
}

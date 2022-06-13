package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;
import com.nhnacademy.springboot.taskgateway.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/tag")
public class TagController {
    private final TagService tagService;

    @GetMapping("/list/{projectNo}")
    public String tagList(@PathVariable("projectNo") Integer projectNo,
                          Model model){
        List<TagDto> tags = tagService.getTagDtoList(projectNo);
        model.addAttribute("tags", tags);
        model.addAttribute("projectNo", projectNo);
        return "tag/tagList";
    }

    @GetMapping("/register/{projectNo}")
    public String registerForm(@PathVariable("projectNo") Integer projectNo,
                               Model model){
        model.addAttribute("projectNo", projectNo);
        return "tag/tagRegisterForm";
    }

    @PostMapping("/register/{projectNo}")
    public String doRegister(@PathVariable("projectNo") Integer projectNo,
                             @Validated TagRequest tagRequest){
        tagService.register(projectNo, tagRequest);
        return "redirect:/tag/list/"+projectNo;
    }
}

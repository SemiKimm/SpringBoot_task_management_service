package com.nhnacademy.springboot.taskgateway.controller;

import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;
import com.nhnacademy.springboot.taskgateway.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
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
                             @Validated TagRequest tagRequest,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        tagService.register(projectNo, tagRequest);
        return "redirect:/tag/list/"+projectNo;
    }

    @GetMapping("/modify/{tagNo}/{projectNo}")
    public String modifyForm(@PathVariable("tagNo") Integer tagNo,
                             @PathVariable("projectNo") Integer projectNo,
                             Model model){
        TagDto tag = tagService.getTagDto(tagNo);

        model.addAttribute("tag", tag);
        model.addAttribute("projectNo", projectNo);
        return "tag/tagModifyForm";
    }

    @PostMapping("/modify/{tagNo}/{projectNo}")
    public String doModify(@PathVariable("tagNo") Integer tagNo,
                           @PathVariable("projectNo") Integer projectNo,
                           @Validated TagRequest tagRequest,
                           BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }
        tagService.modify(tagNo, tagRequest);
        return "redirect:/tag/list/"+projectNo;
    }
}

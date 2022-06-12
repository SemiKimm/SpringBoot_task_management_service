package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.request.TagRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagRestController {
    private final TagService tagService;

    @PostMapping("/register/{projectNo}")
    public Tag doRegister(@PathVariable("projectNo") Integer projectNo,
                          @RequestBody TagRequest tagRequest){
        return tagService.register(projectNo, tagRequest);
    }
}

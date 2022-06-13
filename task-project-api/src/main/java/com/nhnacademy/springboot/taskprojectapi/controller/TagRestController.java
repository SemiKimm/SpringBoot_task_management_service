package com.nhnacademy.springboot.taskprojectapi.controller;

import com.nhnacademy.springboot.taskprojectapi.domain.TagDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.request.TagRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tag")
public class TagRestController {
    private final TagService tagService;

    @PostMapping("/register/{projectNo}")
    public Tag doRegister(@PathVariable("projectNo") Integer projectNo,
                          @RequestBody TagRequest tagRequest){
        return tagService.register(projectNo, tagRequest.getName());
    }

    @PutMapping("/{tagNo}")
    public Integer doModify(@PathVariable("tagNo") Integer tagNo,
                            @RequestBody TagRequest tagRequest){
        return tagService.modify(tagNo, tagRequest.getName());
    }

    @DeleteMapping("/{tagNo}")
    public String doDelete(@PathVariable("tagNo") Integer tagNo){
        return tagService.deleteTag(tagNo);
    }

    @GetMapping("/list/{projectNo}")
    public List<TagDto> getTagDtoList(@PathVariable("projectNo") Integer projectNo){
        return tagService.getTagDtoListBy(projectNo);
    }

    @GetMapping("{tagNo}")
    public Optional<TagDto> getTagDto(@PathVariable("tagNo") Integer tagNo){
        return tagService.getTagDto(tagNo);
    }
}

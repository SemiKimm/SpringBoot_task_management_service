package com.nhnacademy.springboot.taskgateway.service.impl;

import com.nhnacademy.springboot.taskgateway.adapter.ProjectAdapter;
import com.nhnacademy.springboot.taskgateway.adapter.TagAdapter;
import com.nhnacademy.springboot.taskgateway.domain.TagDto;
import com.nhnacademy.springboot.taskgateway.request.TagRequest;
import com.nhnacademy.springboot.taskgateway.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {
    private final TagAdapter tagAdapter;
    private final ProjectAdapter projectAdapter;

    @Override
    public List<TagDto> getTagDtoList(Integer projectNo) {
        return tagAdapter.findTagDtoList(projectNo);
    }

    @Override
    public void register(Integer projectNo, TagRequest tagRequest) {
        if(projectAdapter.findProject(projectNo).isEmpty()){
            throw new NotFoundException("project");
        }
        tagAdapter.create(projectNo, tagRequest);
    }

    @Override
    public TagDto getTagDto(Integer tagNo) {
        return tagAdapter.findTagDto(tagNo).orElseThrow(() -> new NotFoundException("tag"));
    }

    @Override
    public void modify(Integer tagNo, TagRequest tagRequest) {
        if(tagAdapter.findTagDto(tagNo).isEmpty()){
            throw new NotFoundException("tag");
        }
        tagAdapter.update(tagNo, tagRequest);
    }

    @Override
    public void delete(Integer tagNo) {
        if(tagAdapter.findTagDto(tagNo).isEmpty()){
            throw new NotFoundException("tag");
        }
        tagAdapter.deleteByNo(tagNo);
    }
}

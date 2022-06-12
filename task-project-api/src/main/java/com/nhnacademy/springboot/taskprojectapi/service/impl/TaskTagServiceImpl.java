package com.nhnacademy.springboot.taskprojectapi.service.impl;

import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.entity.TaskTag;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.TaskTagPk;
import com.nhnacademy.springboot.taskprojectapi.repository.TagRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskRepository;
import com.nhnacademy.springboot.taskprojectapi.repository.TaskTagRepository;
import com.nhnacademy.springboot.taskprojectapi.request.TaskTagRequest;
import com.nhnacademy.springboot.taskprojectapi.service.TaskTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TaskTagServiceImpl implements TaskTagService {
    private final TaskTagRepository taskTagRepository;
    private final TaskRepository taskRepository;
    private final TagRepository tagRepository;

    @Override
    public TaskTag register(TaskTagRequest taskTagRequest) {
        Task task = taskRepository
                .findById(taskTagRequest.getTaskNo())
                .orElseThrow(() -> new IllegalStateException("not exist task : " + taskTagRequest.getTaskNo()));
        Tag tag = tagRepository
                .findById(taskTagRequest.getTagNo())
                .orElseThrow(() -> new IllegalStateException("not exist tag : " + taskTagRequest.getTagNo()));
        TaskTagPk taskTagPk = new TaskTagPk(task.getNo(), tag.getNo());

        TaskTag taskTag = new TaskTag(taskTagPk, task, tag);

        return taskTagRepository.saveAndFlush(taskTag);
    }
}

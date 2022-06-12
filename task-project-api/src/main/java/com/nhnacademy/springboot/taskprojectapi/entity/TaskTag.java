package com.nhnacademy.springboot.taskprojectapi.entity;

import com.nhnacademy.springboot.taskprojectapi.entity.pk.TaskTagPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tool_task_tag")
public class TaskTag {
    @EmbeddedId
    private TaskTagPk pk;

    @MapsId("taskNo")
    @ManyToOne
    @JoinColumn(name = "task_no", nullable = false)
    private Task task;

    @MapsId("tagNo")
    @ManyToOne
    @JoinColumn(name = "tag_no", nullable = false)
    private Tag tag;
}

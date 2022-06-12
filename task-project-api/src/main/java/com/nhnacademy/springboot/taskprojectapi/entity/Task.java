package com.nhnacademy.springboot.taskprojectapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_no", nullable = false)
    private Integer no;
    @Column(name = "task_create_datetime", nullable = false)
    private LocalDateTime createDateTime;
    @Column(name = "task_title", nullable = false)
    private String title;
    @Column(name = "task_content", nullable = true)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "participant_account_id", nullable = false),
            @JoinColumn(name = "project_no", nullable = false)
    })
    private Participant registrant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_no", nullable = true)
    private Milestone milestone;

    public static Task create(String title, String content, Participant registrant){
        Task task = new Task();
        task.setCreateDateTime(LocalDateTime.now());
        task.setTitle(title);
        task.setContent(content);
        task.setRegistrant(registrant);

        return task;
    }
}

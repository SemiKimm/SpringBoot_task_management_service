package com.nhnacademy.springboot.taskprojectapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no", nullable = false)
    private Integer no;
    @Column(name = "writer_account_id", nullable = false)
    private String writerId;
    @Column(name = "comment_content", nullable = false)
    private String content;
    @Column(name = "comment_write_datetime", nullable = false)
    private LocalDateTime writeDateTime;
    @Column(name = "comment_modify_datetime", nullable = true)
    private LocalDateTime modifyDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_no", nullable = false)
    private Task task;

    public static Comment create(String writerId, String content, Task task){
        Comment comment = new Comment();
        comment.setWriterId(writerId);
        comment.setContent(content);
        comment.setWriteDateTime(LocalDateTime.now());
        comment.setTask(task);

        return comment;
    }
}

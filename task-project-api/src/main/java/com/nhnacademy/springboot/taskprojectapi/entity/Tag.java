package com.nhnacademy.springboot.taskprojectapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_no", nullable = false)
    private Integer no;

    @Column(name = "tag_name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_no", nullable = false)
    private Project project;

    public static Tag create(String name, Project project){
        Tag tag = new Tag();
        tag.setName(name);
        tag.setProject(project);

        return tag;
    }
}

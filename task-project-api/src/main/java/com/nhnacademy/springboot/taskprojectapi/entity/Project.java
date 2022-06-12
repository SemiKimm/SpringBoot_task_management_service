package com.nhnacademy.springboot.taskprojectapi.entity;

import com.nhnacademy.springboot.taskprojectapi.enumm.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_no", nullable = false)
    private Integer no;
    @Column(name = "project_state", nullable = false)
    private String state;
    @Column(name = "project_name", nullable = false)
    private String name;
    @Column(name = "project_explanation", nullable = true)
    private String explanation;

    public static Project create(String name, String explanation){
        Project project = new Project();
        project.setState(State.ACTIVE.getState());
        project.setName(name);
        project.setExplanation(explanation);

        return project;
    }
}

package com.nhnacademy.springboot.taskprojectapi.entity;

import com.nhnacademy.springboot.taskprojectapi.enumm.State;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_milestones")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_no", nullable = false)
    private Integer no;
    @Column(name = "milestone_name", nullable = false)
    private String name;
    @Column(name = "milestone_state", nullable = false)
    private String state;
    @Column(name = "milestone_start_date", nullable = true)
    private LocalDate startDate;
    @Column(name = "milestone_finish_date", nullable = true)
    private LocalDate finishDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_no", nullable = false)
    private Project project;

    public static Milestone create(String name, Project project){
        Milestone milestone = new Milestone();
        milestone.setName(name);
        milestone.setState(State.ACTIVE.getState());
        milestone.setProject(project);

        return milestone;
    }
}

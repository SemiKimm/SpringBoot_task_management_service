package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskDetailDto;
import com.nhnacademy.springboot.taskprojectapi.domain.TaskDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Transactional
    @Modifying
    @Query("update Task t set t.title = :title, t.content = :content where t.no = :taskNo")
    Integer updateTask(@Param("taskNo") Integer taskNo,
                       @Param("title") String title,
                       @Param("content") String content);

    @Transactional
    @Modifying
    @Query("update Task t set t.title = :title, t.content = :content, t.milestone = :milestone where t.no = :taskNo")
    Integer updateTaskWithMilestone(@Param("taskNo") Integer taskNo,
                                    @Param("title") String title,
                                    @Param("content") String content,
                                    @Param("milestone") Milestone milestone);

    @Query("select t from Task t where t.registrant.pk.projectNo = :projectNo")
    List<TaskDto> findTaskDtoListBy(@Param("projectNo") Integer projectNo);

    @Transactional
    @Modifying
    @Query("update Task t set t.milestone = null where t.milestone.no = :milestoneNo")
    Integer deleteMilestoneBy(@Param("milestoneNo") Integer milestoneNo);

    @Query("select t from Task t where t.no = :taskNo")
    Optional<TaskDetailDto> findTaskDetailDtoBy(@Param("taskNo") Integer taskNo);
}

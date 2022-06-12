package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Transactional
    @Modifying
    @Query("update Task t set t.title = :title, t.content = :content where t.no = :taskNo")
    Integer updateTask(@Param("taskNo") Integer taskNo,
                       @Param("title") String title,
                       @Param("content") String content);

    @Query("select t from Task t where t.registrant.pk.projectNo = :projectNo")
    List<TaskDto> findTaskDtoListBy(@Param("projectNo") Integer projectNo);
}

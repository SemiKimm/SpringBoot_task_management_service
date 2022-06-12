package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.domain.TaskTagDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import com.nhnacademy.springboot.taskprojectapi.entity.TaskTag;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.TaskTagPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskTagRepository extends JpaRepository<TaskTag, TaskTagPk> {
    @Query("select tt from TaskTag tt where tt.task = :task")
    List<TaskTagDto> findTaskTagDtoBy(@Param("task") Task task);

    @Transactional
    @Modifying
    @Query("delete from TaskTag tt where tt.tag.no = :tagNo")
    Integer deleteByTag(@Param("tagNo") Integer tagNo);
}

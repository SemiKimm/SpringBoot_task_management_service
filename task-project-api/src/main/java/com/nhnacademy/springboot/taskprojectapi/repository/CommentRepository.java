package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.domain.CommentDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Comment;
import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Transactional
    @Modifying
    @Query("update Comment c set c.content = :content, " +
            "c.modifyDateTime = :modifyDateTime " +
            "where c.no = :commentNo")
    Integer update(@Param("commentNo") Integer commentNo,
                   @Param("content") String content,
                   @Param("modifyDateTime") LocalDateTime modifyDateTime);

    @Query("select c from Comment c where c.task = :task")
    List<CommentDto> findCommentDtoListBy(@Param("task") Task task);

    @Query("select c from Comment c where c.no = :commentNo")
    Optional<CommentDto> findCommentDtoBy(@Param("commentNo") Integer commentNo);
}

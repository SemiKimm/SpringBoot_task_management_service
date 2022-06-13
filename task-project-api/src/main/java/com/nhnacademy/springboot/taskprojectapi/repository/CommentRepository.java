package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Transactional
    @Modifying
    @Query("update Comment c set c.content = :content, " +
            "c.modifyDateTime = :modifyDateTime " +
            "where c.no = :commentNo")
    Integer update(@Param("commentNo") Integer commentNo,
                   @Param("content") String content,
                   @Param("modifyDateTime") LocalDateTime modifyDateTime);
}

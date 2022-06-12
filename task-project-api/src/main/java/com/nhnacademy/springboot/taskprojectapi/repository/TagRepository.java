package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    @Transactional
    @Modifying
    @Query("update Tag t set t.name = :name where t.no = :tagNo")
    Integer update(@Param("tagNo") Integer tagNo,
                   @Param("name") String name);
}

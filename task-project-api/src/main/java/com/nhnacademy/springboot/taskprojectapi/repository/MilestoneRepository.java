package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface MilestoneRepository extends JpaRepository<Milestone, Integer> {
    @Transactional
    @Modifying
    @Query("update Milestone m set m.name = :name, " +
            "m.startDate = :startDate, " +
            "m.finishDate = :finishDate " +
            "where m.no = :milestoneNo")
    Integer update(@Param("milestoneNo") Integer milestoneNo,
                             @Param("name") String name,
                             @Param("startDate") LocalDate startDate,
                             @Param("finishDate") LocalDate finishDate);

    @Transactional
    @Modifying
    @Query("update Milestone m set m.state = :state where m.no = :milestoneNo")
    Integer updateState(@Param("milestoneNo") Integer milestoneNo,
                        @Param("state") String state);
}

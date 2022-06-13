package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.domain.MilestoneDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Milestone;
import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Query("select m from Milestone m where m.project = :project and m.state = :state")
    List<MilestoneDto> findAllByProjectAndState(@Param("project") Project project,
                                                @Param("state") String state);

    @Query("select m from Milestone m where m.no = :milestoneNo")
    Optional<MilestoneDto> findMilestoneDto(@Param("milestoneNo") Integer milestoneNo);
}

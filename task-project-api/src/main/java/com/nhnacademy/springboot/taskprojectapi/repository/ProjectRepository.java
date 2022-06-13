package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.entity.Project;
import com.nhnacademy.springboot.taskprojectapi.repository.custom.ProjectRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProjectRepository extends JpaRepository<Project, Integer>, ProjectRepositoryCustom {
    @Transactional
    @Modifying
    @Query("update Project p set p.state = :state, p.name = :name, p.explanation = :explanation where p.no = :projectNo")
    Integer updateProjectInfo(@Param("projectNo") Integer projectNo,
                              @Param("state") String state,
                              @Param("name") String name,
                              @Param("explanation") String explanation);
}

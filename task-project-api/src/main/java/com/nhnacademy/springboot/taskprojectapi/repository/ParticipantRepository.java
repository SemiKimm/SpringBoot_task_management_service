package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.domain.ParticipantDto;
import com.nhnacademy.springboot.taskprojectapi.entity.Participant;
import com.nhnacademy.springboot.taskprojectapi.entity.pk.ParticipantPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, ParticipantPk> {
    @Query("select p from Participant p where p.pk.projectNo = :projectNo")
    List<ParticipantDto> findParticipantsBy(@Param("projectNo") Integer projectNo);
}

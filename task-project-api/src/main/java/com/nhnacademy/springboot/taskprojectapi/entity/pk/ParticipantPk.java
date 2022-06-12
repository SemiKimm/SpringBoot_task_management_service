package com.nhnacademy.springboot.taskprojectapi.entity.pk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ParticipantPk implements Serializable {
    @Column(name = "participant_account_id", nullable = false)
    private String participantId;

    private Integer projectNo;
}

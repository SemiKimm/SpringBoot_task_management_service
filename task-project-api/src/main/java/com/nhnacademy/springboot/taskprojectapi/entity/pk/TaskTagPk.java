package com.nhnacademy.springboot.taskprojectapi.entity.pk;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TaskTagPk implements Serializable {
    private Integer taskNo;
    private Integer tagNo;
}

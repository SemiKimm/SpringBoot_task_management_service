package com.nhnacademy.springboot.taskaccountapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_authorities")
public class Authority {
    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "authority", nullable = false)
    private String authority;
}

package com.nhnacademy.springboot.taskaccountapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tool_authorities")
public class Authority {
    @Id
    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "authority", nullable = false)
    private String authority;

    @MapsId
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}

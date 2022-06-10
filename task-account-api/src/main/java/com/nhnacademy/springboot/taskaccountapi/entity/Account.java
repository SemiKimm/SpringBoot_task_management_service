package com.nhnacademy.springboot.taskaccountapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tool_accounts")
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    private String id;
    @Column(name = "account_password", nullable = false)
    private String password;
    @Column(name = "account_email", nullable = false)
    private String email;
    @Column(name = "account_state", nullable = false)
    private String state;

    @OneToOne(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Authority authority;

    public static Account create(String id, String pwd, String email){
        Account account = new Account();
        account.setId(id);
        account.setPassword(pwd);
        account.setEmail(email);
        account.setState("가입");

        return account;
    }
}
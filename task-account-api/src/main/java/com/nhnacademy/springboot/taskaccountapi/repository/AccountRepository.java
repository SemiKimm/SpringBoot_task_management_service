package com.nhnacademy.springboot.taskaccountapi.repository;

import com.nhnacademy.springboot.taskaccountapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Transactional
    @Modifying
    @Query("update Account a set a.state = :state where a.id = :id")
    void updateAccountState(@Param("id") String id,
                            @Param("state") String state);
}

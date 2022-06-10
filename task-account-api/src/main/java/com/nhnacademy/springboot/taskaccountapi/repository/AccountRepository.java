package com.nhnacademy.springboot.taskaccountapi.repository;

import com.nhnacademy.springboot.taskaccountapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}

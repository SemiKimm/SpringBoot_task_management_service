package com.nhnacademy.springboot.taskprojectapi.repository;

import com.nhnacademy.springboot.taskprojectapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}

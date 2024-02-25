package com.karalaitis.planner.tasks.dao;

import com.karalaitis.planner.tasks.pojo.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByGoalGoalId(UUID goalId, Pageable pageable);
}
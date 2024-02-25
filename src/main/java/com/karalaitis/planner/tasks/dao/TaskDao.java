package com.karalaitis.planner.tasks.dao;

import com.karalaitis.planner.tasks.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDao {

    private final TaskRepository repository;

    @Autowired
    public TaskDao(TaskRepository taskRepository) {
        this.repository = taskRepository;
    }

    public Page<Task> getTaskPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Task> getTasksByGoalId(long goalId, Pageable pageable) {
        return repository.findByGoalId(goalId, pageable);
    }
}
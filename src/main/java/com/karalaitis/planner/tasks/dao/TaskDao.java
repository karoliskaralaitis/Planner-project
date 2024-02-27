package com.karalaitis.planner.tasks.dao;

import com.karalaitis.planner.tasks.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    public Page<Task> getTasksByGoalId(UUID goalId, Pageable pageable) {
        return repository.findByGoalGoalId(goalId, pageable);
    }

    public void deleteTaskByUUID(UUID id) {
        repository.deleteTaskByTaskId(id);
    }
    public Task getTaskByTaskId(UUID taskId) {
        return repository.findByTaskId(taskId);
    }
}
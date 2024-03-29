package com.karalaitis.planner.goals.service;

import com.karalaitis.planner.goals.dao.TaskDao;
import com.karalaitis.planner.goals.dto.TaskDto;
import com.karalaitis.planner.goals.mappers.TaskMapper;
import com.karalaitis.planner.goals.pojo.Task;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {

    private final TaskDao taskDao;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskDao taskDao, TaskMapper taskMapper){
        this.taskDao = taskDao;
        this.taskMapper = taskMapper;
    }

    public Page<TaskDto> getAllTasks(Pageable pageable) {
        return taskDao.getTaskPage(pageable).map(task -> taskMapper.toTaskDto(task));
    }

    public Page<TaskDto> getTasksByGoalId(UUID goalId, Pageable pageable) {
        return taskDao.getTasksByGoalId(goalId, pageable).map(taskMapper::toTaskDto);
    }

    @Transactional
    public void deleteTaskByUUID(UUID id) {
        taskDao.deleteTaskByUUID(id);
    }

    public UUID getGoalIdByTaskId(UUID taskId) {
        Task task = taskDao.getTaskByTaskId(taskId);
        return (task != null) ? task.getGoal().getGoalId() : null;
    }
}
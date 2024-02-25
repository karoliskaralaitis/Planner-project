package com.karalaitis.planner.tasks.service;

import com.karalaitis.planner.tasks.dao.TaskDao;
import com.karalaitis.planner.tasks.dto.TaskDto;
import com.karalaitis.planner.tasks.mappers.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskService {

    private TaskDao taskDao;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskDao taskDao, TaskMapper taskMapper){
        this.taskDao = taskDao;
        this.taskMapper = taskMapper;
    }

    public Page<TaskDto> getAllTasks(Pageable pageable) {
        return taskDao.getTaskPage(pageable).map(task -> taskMapper.toTaskDto(task));
    }

    public Page<TaskDto> getTasksByGoalId(long goalId, Pageable pageable) {
        return taskDao.getTasksByGoalId(goalId, pageable).map(taskMapper::toTaskDto);
    }
}
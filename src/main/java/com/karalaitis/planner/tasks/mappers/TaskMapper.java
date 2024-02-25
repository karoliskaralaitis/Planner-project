package com.karalaitis.planner.tasks.mappers;

import com.karalaitis.planner.tasks.dto.TaskDto;
import com.karalaitis.planner.tasks.pojo.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toTaskDto(Task task) {
        return new TaskDto(
                task.getTaskId(),
                task.getTaskName(),
                task.getTaskFinishDate(),
                task.getTaskComment(),
                task.getTaskCreationDate()
        );
    }

    public Task fromTaskDto(TaskDto taskDto) {
        return Task.builder()
                .taskId(taskDto.getTaskId())
                .taskName(taskDto.getTaskName())
                .taskFinishDate(taskDto.getTaskFinishDate())
                .taskComment(taskDto.getTaskComment())
                .taskCreationDate(taskDto.getTaskCreationDate())
                .build();
    }
}
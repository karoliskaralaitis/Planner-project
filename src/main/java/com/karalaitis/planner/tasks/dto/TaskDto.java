package com.karalaitis.planner.tasks.dto;

import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class TaskDto {
    private UUID taskId;
    @NotBlank(message = "{taskdto.name.notBlank}")
    private String taskName;
    private LocalDate taskFinishDate;
    private String taskComment;
    private LocalDateTime taskCreationDate;

    @PrePersist
    protected void onCreate() {
        taskCreationDate = LocalDateTime.now();
    }
}
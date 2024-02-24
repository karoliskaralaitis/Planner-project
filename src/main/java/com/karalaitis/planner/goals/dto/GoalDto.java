package com.karalaitis.planner.goals.dto;

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
public class GoalDto {
    private UUID goalId;
    @NotBlank(message = "{goaldto.name.notBlank}")
    private String name;
    private LocalDate doByDate;
    private String comment;
    private LocalDateTime dateOfCreation;

    @PrePersist
    protected void onCreate() {
        dateOfCreation = LocalDateTime.now();
    }
}
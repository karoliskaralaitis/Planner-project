package com.karalaitis.planner.goals.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;
    private LocalDate doByDate;
    private String comment;
    private LocalDateTime dateOfCreation;
}
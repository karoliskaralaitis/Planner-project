package com.karalaitis.planner.goals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
public class GoalDto {
    private UUID goalId;
    private String name;
    private LocalDate doByDate;
    private String comment;
    private LocalDateTime dateOfCreation;
}
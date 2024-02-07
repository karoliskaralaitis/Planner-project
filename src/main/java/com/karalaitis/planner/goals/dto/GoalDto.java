package com.karalaitis.planner.goals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class GoalDto {
    private UUID goalId;
    private String name;
    private String doByDate;
    private String comment;
}
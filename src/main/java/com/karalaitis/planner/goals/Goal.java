package com.karalaitis.planner.goals;

import lombok.*;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goal {
    private UUID goalId;
    private String name;
    private String doByDate;
//    private int numberOfTasks;
//    private int numberOfSteps;
    private String comment;
//    private String dateOfCreation;
}

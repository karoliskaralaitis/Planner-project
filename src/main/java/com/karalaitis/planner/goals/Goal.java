package com.karalaitis.planner.goals;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goal {
    private String name;
    private String doByDate;
//    private int numberOfTasks;
//    private int numberOfSteps;
    private String comment;
//    private String dateOfCreation;
}

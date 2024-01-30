package com.karalaitis.planner.goals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Goal {
    private String name;
    private String doByDate;
    private int numberOfTasks;
    private int numberOfSteps;
    private String comment;
    private String dateOfCreation;
}

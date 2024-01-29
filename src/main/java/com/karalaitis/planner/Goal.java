package com.karalaitis.planner;

import lombok.Data;

@Data
public class Goal {
    private String Name;
    private String DoByDate;
    private int NumberOfTasks;
    private int NumberOfSteps;
    private String Comment;
    private String DateOfCreation;
}

package com.karalaitis.planner.goals;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID goalId;
    private String name;
    private String doByDate;
//    private int numberOfTasks;
//    private int numberOfSteps;
    private String comment;
//    private String dateOfCreation;
}

package com.karalaitis.planner.goals.pojo;

import com.karalaitis.planner.goals.pojo.Goal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TASK_ID")
    private UUID taskId;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "TASK_FINISH_DATE")
    private LocalDate taskFinishDate;

    @Column(name = "TASK_COMMENT")
    private String taskComment;

    @Column(name = "TASK_CREATION_DATE")
    private LocalDateTime taskCreationDate;

    @ManyToOne
    @JoinColumn(name = "GOAL_ID")
    private Goal goal;
}
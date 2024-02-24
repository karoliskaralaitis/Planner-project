package com.karalaitis.planner.tasks.pojo;

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
    private UUID taskId;
    private String taskName;
    private LocalDate taskFinishDate;
    private String taskComment;
    private LocalDateTime taskCreationDate;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
}

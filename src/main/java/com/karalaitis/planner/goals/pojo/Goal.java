package com.karalaitis.planner.goals.pojo;

import com.karalaitis.planner.tasks.pojo.Task;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "DO_BY_DATE")
    private LocalDate doByDate;
    private String comment;

    @Column(name = "DATE_OF_CREATION")
    private LocalDateTime dateOfCreation;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}
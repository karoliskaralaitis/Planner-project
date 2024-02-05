package com.karalaitis.planner.goals;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GoalDao {
    private List<Goal> goals = new ArrayList<>();

    public void save (Goal goal){
        goal.setUuid(UUID.randomUUID());
        goals.add(goal);
    }

    public List<Goal> getAll() {
        return goals;
    }
}

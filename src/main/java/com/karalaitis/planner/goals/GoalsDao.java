package com.karalaitis.planner.goals;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GoalsDao {
    private List<Goal> goals = new ArrayList<>();

    public void save (Goal goal){
        goals.add(goal);
    }

    public List<Goal> getAll() {
        return goals;
    }
}

package com.karalaitis.planner.goals;

import java.util.List;
import java.util.UUID;

public interface GoalDao {

    public void save (Goal goal);

    public void update (Goal goal);

    public List<Goal> getAll();

    public Goal getGoalByUUID(UUID id);

    public void deleteGoalByUUID(UUID id);
}

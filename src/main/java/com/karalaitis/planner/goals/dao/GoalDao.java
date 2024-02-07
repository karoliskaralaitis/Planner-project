package com.karalaitis.planner.goals.dao;

import com.karalaitis.planner.goals.Goal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GoalDao {

    public void save (Goal goal);

    public void update (Goal goal);

    public List<Goal> getAll();

    public Page<Goal> getPage(Pageable pageable);

    public Goal getGoalByUUID(UUID id);

    public void deleteGoalByUUID(UUID id);
}

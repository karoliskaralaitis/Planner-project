package com.karalaitis.planner.goals;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Primary
@Repository
public class GoalJDBCDao implements GoalDao{
    @Override
    public void save(Goal goal) {

    }

    @Override
    public void update(Goal goal) {

    }

    @Override
    public List<Goal> getAll() {
        return null;
    }

    @Override
    public Goal getGoalByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteGoalByUUID(UUID id) {

    }
}

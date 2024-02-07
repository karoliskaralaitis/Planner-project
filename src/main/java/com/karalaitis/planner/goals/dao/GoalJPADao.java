package com.karalaitis.planner.goals.dao;

import com.karalaitis.planner.goals.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Primary
public class GoalJPADao implements GoalDao{

    GoalRepository repository;
    @Autowired
    public GoalJPADao(GoalRepository goalRepository){
        this.repository = goalRepository;
    }

    @Override
    public void save(Goal goal) {
        goal.setGoalId(UUID.randomUUID());
        repository.save(goal);
    }

    @Override
    public void update(Goal goal) {
        repository.save(goal);
    }

    @Override
    public List<Goal> getAll() {
        return repository.findAll();
    }

    @Override
    public Goal getGoalByUUID(UUID id) {
        return repository.findByGoalId(id);
    }

    @Override
    public void deleteGoalByUUID(UUID id) {
        repository.deleteGoalByGoalId(id);
    }
}

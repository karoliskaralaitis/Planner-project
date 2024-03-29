package com.karalaitis.planner.goals.dao;

import com.karalaitis.planner.goals.pojo.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Primary
public class GoalJPADao implements GoalDao {

    private final GoalRepository repository;

    @Autowired
    public GoalJPADao(GoalRepository goalRepository) {
        this.repository = goalRepository;
    }

    @Override
    public void save(Goal goal) {
        goal.setGoalId(UUID.randomUUID());
        repository.save(goal);
    }

    @Override
    public void update(Goal goal) {
        var goalToUpdate = repository.findByGoalId(goal.getGoalId());
        goalToUpdate.setName(goal.getName());
        goalToUpdate.setDoByDate(goal.getDoByDate());
        goalToUpdate.setComment(goal.getComment());
        repository.save(goalToUpdate);
    }

    @Override
    public List<Goal> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Goal> getPage(Pageable pageable) {
        return repository.findAll(pageable);
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
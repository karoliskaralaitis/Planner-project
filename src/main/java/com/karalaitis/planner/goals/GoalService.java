package com.karalaitis.planner.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GoalService {

    private GoalDao goalDao;

    @Autowired
    public GoalService(GoalDao goalDao){
        this.goalDao = goalDao;
    }

    public void saveGoal(Goal goal) {
        goalDao.save(goal);
    }

    public void updateGoal(Goal goal) {
        goalDao.update(goal);
    }

    public List<Goal> getAllGoals() {
       return goalDao.getAll();
    }

    public Goal getGoalByUUID(UUID id){
        return goalDao.getGoalByUUID(id);
    }

    public void deleteGoalByUUID(UUID id) {
        goalDao.deleteGoalByUUID(id);
    }
}

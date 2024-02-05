package com.karalaitis.planner.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Goal> getAllGoals() {
       return goalDao.getAll();
    }
}

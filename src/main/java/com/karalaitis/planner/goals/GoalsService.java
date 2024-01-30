package com.karalaitis.planner.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalsService {

    private GoalsDao goalsDao;

    @Autowired
    public GoalsService(GoalsDao goalsDao){
        this.goalsDao = goalsDao;
    }

    public void saveGoal(Goal goal) {
        goalsDao.save(goal);
    }

    public List<Goal> getAllGoals() {
       return goalsDao.getAll();
    }
}

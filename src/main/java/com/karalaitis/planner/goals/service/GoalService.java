package com.karalaitis.planner.goals.service;

import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.mappers.GoalMapper;
import com.karalaitis.planner.goals.dto.GoalDto;
import com.karalaitis.planner.goals.dao.GoalDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GoalService {

    private GoalDao goalDao;
    private GoalMapper mapper;

    @Autowired
    public GoalService(GoalDao goalDao, GoalMapper mapper){
        this.goalDao = goalDao;
        this.mapper = mapper;
    }

    public void saveGoal(GoalDto goalDto) {
        var goal = mapper.fromGoalDto(goalDto);
        goalDao.save(goal);
    }

    public void updateGoal(Goal goal) {
        goalDao.update(goal);
    }

    public Page<GoalDto> getAllGoalsPage(Pageable pageable) {
       return goalDao.getPage(pageable).map(goal -> mapper.toGoalDto(goal));
    }

    public GoalDto getGoalByUUID(UUID id){
        return mapper.toGoalDto(goalDao.getGoalByUUID(id));
    }

    @Transactional
    public void deleteGoalByUUID(UUID id) {
        goalDao.deleteGoalByUUID(id);
    }
}

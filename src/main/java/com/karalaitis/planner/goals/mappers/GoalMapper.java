package com.karalaitis.planner.goals.mappers;

import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.dto.GoalDto;
import org.springframework.stereotype.Component;

@Component
public class GoalMapper {

    public GoalDto toGoalDto(Goal goal) {
        return new GoalDto(
                goal.getGoalId(),
                goal.getName(),
                goal.getDoByDate(),
                goal.getComment()
        );
    }
}

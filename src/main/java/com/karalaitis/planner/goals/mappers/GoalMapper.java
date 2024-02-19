package com.karalaitis.planner.goals.mappers;

import com.karalaitis.planner.goals.pojo.Goal;
import com.karalaitis.planner.goals.dto.GoalDto;
import org.springframework.stereotype.Component;

@Component
public class GoalMapper {

    public GoalDto toGoalDto(Goal goal) {
        return new GoalDto(
                goal.getGoalId(),
                goal.getName(),
                goal.getDoByDate(),
                goal.getComment(),
                goal.getDateOfCreation()
        );
    }

    public Goal fromGoalDto(GoalDto goalDto) {
        return Goal.builder()
                .goalId(goalDto.getGoalId())
                .name(goalDto.getName())
                .doByDate(goalDto.getDoByDate())
                .comment(goalDto.getComment())
                .dateOfCreation(goalDto.getDateOfCreation())
                .build();
    }
}

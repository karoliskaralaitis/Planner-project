package com.karalaitis.planner.config;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.GoalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GoalDataMockConfig {

    private static final int MAX_COUNT = 10;

    private final GoalService goalService;
    @Bean
    public Void initGoals() {
        final Faker faker = new Faker();
        var count = 0;
        while (MAX_COUNT >= count) {
            goalService.saveGoal(Goal.builder().name(faker.lorem().sentence())
                    .doByDate(faker.lorem().word())
                    .comment(faker.lorem().sentence())
                    .build());
            count++;
        }
        return null;
    }
}

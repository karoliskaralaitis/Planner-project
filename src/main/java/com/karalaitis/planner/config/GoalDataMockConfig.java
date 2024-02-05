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
            goalService.saveGoal(new Goal(faker.lorem().sentence(), faker.lorem().word(), faker.lorem().sentence()));
            count++;
        }
        return null;
    }
}

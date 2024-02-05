package com.karalaitis.planner.config;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.GoalService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Log4j2
public class GoalDataMockConfig {

    private static final int MAX_COUNT = 10;

    private final GoalService goalService;
    @Bean
    public Void initGoals() {
        log.atDebug().log("--=== initGoals initialization beginning ===--");
        final Faker faker = new Faker();
        var count = 0;
        while (MAX_COUNT >= count) {
            goalService.saveGoal(Goal.builder().name(faker.lorem().sentence())
                    .doByDate(faker.lorem().word())
                    .comment(faker.lorem().sentence())
                    .build());
            count++;
        }
        log.atDebug().log("--=== initGoals initialization end ===--");
        return null;
    }
}

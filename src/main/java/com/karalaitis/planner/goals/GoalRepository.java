package com.karalaitis.planner.goals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    Goal findByGoalId(UUID id);

    void deleteGoalByGoalId(UUID id);
}

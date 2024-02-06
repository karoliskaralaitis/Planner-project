package com.karalaitis.planner.goals;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GoalMockDao implements GoalDao {
    private Map<UUID, Goal> goals = new HashMap();

    public void save (Goal goal) {
        final UUID uuid = UUID.randomUUID();
        goal.setGoalId(uuid);
        goals.put(uuid, goal);
    }

    public void update (Goal goal){
        goals.put(goal.getGoalId(), goal);
    }

    public List<Goal> getAll() {
        return new ArrayList<>(goals.values());
    }

    public Goal getGoalByUUID(UUID id){
        return goals.get(id);
    }

    public void deleteGoalByUUID(UUID id) {
        goals.remove(id);
    }
}

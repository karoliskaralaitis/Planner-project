package com.karalaitis.planner.goals;

import com.karalaitis.planner.mapper.GoalJDBCRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GoalJDBCDao implements GoalDao{

    private final JdbcTemplate jdbcTemplate;
    private final GoalJDBCRowMapper goalJDBCRowMapper;
    @Override
    public void save(Goal goal) {
        goal.setGoalId(UUID.randomUUID());
        jdbcTemplate.update("INSERT INTO GOAL(GOAL_ID, NAME, DOBYDATE, COMMENT) VALUES (?, ?, ?, ?)",
                goal.getGoalId(), goal.getName(), goal.getDoByDate(), goal.getComment());
    }

    @Override
    public void update(Goal goal) {
        jdbcTemplate.update("UPDATE GOAL SET name = ?, doByDate = ?, comment = ? WHERE goal_id = ?",
                goal.getName(), goal.getDoByDate(), goal.getComment(), goal.getGoalId());
    }

    @Override
    public List<Goal> getAll() {
        return jdbcTemplate.query(
            "SELECT * FROM GOAL", goalJDBCRowMapper);
    }

    @Override
    public Goal getGoalByUUID(UUID id) {
        final List<Goal> goals = jdbcTemplate.query(
                String.format("SELECT * FROM GOAL WHERE goal_id = '%s'", id.toString()), goalJDBCRowMapper);
        return goals.get(0);
    }

    @Override
    public void deleteGoalByUUID(UUID id) {
        jdbcTemplate.execute(String.format("DELETE FROM GOAL WHERE GOAL_ID = '%s'", id.toString()));
    }
}

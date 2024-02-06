package com.karalaitis.planner.mapper;

import com.karalaitis.planner.goals.Goal;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class GoalJDBCRowMapper implements RowMapper<Goal> {
    @Override
    public Goal mapRow (ResultSet rs,int rowNum) throws SQLException {
        return Goal.builder()
            .goalId(UUID.fromString(rs.getString("goal_id")))
            .name(rs.getString("name"))
            .doByDate(rs.getString("doByDate"))
            .comment(rs.getString("comment"))
            .build();
    }
}

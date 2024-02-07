package com.karalaitis.planner.goals.controllers;

import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.dto.GoalDto;
import com.karalaitis.planner.goals.service.GoalService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Controller
@Log4j2
public class GoalController {

    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping("/goals/create")
    public String showGoalCreationPage(Model model){
        model.addAttribute("goal", Goal.builder().build());
        return "goals/goals";
    }

    @GetMapping("/goals/{goalId}/update")
    public String showGoalUpdatePage(Model model, @PathVariable UUID goalId){
        model.addAttribute("goal", goalService.getGoalByUUID(goalId));
        return "goals/goals";
    }

    @PostMapping("/goals/create")
    public String createGoal(Model model, Goal goal) {
        goalService.saveGoal(goal);
        model.addAttribute("message", "Goal added successfully!");
        return "goals/goals";
    }

    @PostMapping("/goals/{goalId}/update")
    public String updateGoal(Model model, Pageable pageable, Goal goal, @PathVariable UUID goalId) {
        goalService.updateGoal(goal);
        return getGoals(model, pageable);
    }

    @GetMapping("/goals")
    public String getGoals(Model model, Pageable pageable){
        final Page<GoalDto> allGoals = goalService.getAllGoalsPage(pageable);
        model.addAttribute("goalList", allGoals);
        return "goals/goalsList";
    }

    @GetMapping("/goals/{goalId}/delete")
    public String deleteGoal(Model model, Pageable pageable, @PathVariable UUID goalId) {
        goalService.deleteGoalByUUID(goalId);
        return getGoals(model, pageable);
    }
}

package com.karalaitis.planner.goals.controllers;

import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.dto.GoalDto;
import com.karalaitis.planner.goals.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.UUID;

@Controller
public class GoalController {

    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping("/goals/create")
    public String showGoalCreationPage(Model model){
        model.addAttribute("goal", Goal.builder().build());
        return "goals/goalsCreate";
    }

    @GetMapping("/goals/{goalId}/update")
    public String showGoalUpdatePage(Model model, @PathVariable UUID goalId){
        model.addAttribute("goal", goalService.getGoalByUUID(goalId));
        return "goals/goalsCreate";
    }

    @PostMapping("/goals/create")
    public String createGoal(Model model, Goal goal) {
        goalService.saveGoal(goal);
        model.addAttribute("message", "Goal added successfully!");
        return "goals/goalsCreate";
    }

    @PostMapping("/goals/{goalId}/update")
    public String updateGoal(Model model, Pageable pageable, Goal goal, @PathVariable UUID goalId) {
        goalService.updateGoal(goal);
        return getGoals(model, pageable);
    }

    @GetMapping("/goals")
    public String getGoals(Model model, @PageableDefault(size = 3, sort = {"doByDate"}, direction = Sort.Direction.ASC) Pageable pageable){
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

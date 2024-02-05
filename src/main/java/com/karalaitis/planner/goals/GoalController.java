package com.karalaitis.planner.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;
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
        return "goals/goals";
    }

    @GetMapping("/goals/{goalId}/update")
    public String showGoalUpdatePage(Model model, @PathVariable UUID goalId){
        model.addAttribute("goal", goalService.getGoalByUUID(goalId));
        return "goals/goals";
    }

    @PostMapping("/goals/create")
    public String createAGoal(Model model, Goal goal) {
        goalService.saveGoal(goal);
        return getGoals(model);
    }

    @PostMapping("/goals/{goalId}/update")
    public String updateAGoal(Model model, Goal goal) {
        goalService.updateGoal(goal);
        return getGoals(model);
    }

    @GetMapping("/goals")
    public String getGoals(Model model){
        List<Goal> allGoals = goalService.getAllGoals();
        model.addAttribute("goalList", allGoals);
        return "goals/goalsList";
    }

    @GetMapping("/goals/{goalId}/delete")
    public String deleteGoal(Model model, @PathVariable UUID goalId) {
        goalService.deleteGoaltByUUID(goalId);
        return getGoals(model);
    }
}

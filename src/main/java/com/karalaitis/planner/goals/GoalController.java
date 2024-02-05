package com.karalaitis.planner.goals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

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

    @PostMapping("/goals/create")
    public String createAGoal(Goal goal) {
        goalService.saveGoal(goal);
        System.out.println("In database:");
        goalService.getAllGoals().forEach(System.out::println);
        return "index/index";
    }

    @GetMapping("/goals")
    public String getGoals(Model model){
        List<Goal> allGoals = goalService.getAllGoals();
        model.addAttribute("goalList", allGoals);
        return "goals/goalsList";
    }

}

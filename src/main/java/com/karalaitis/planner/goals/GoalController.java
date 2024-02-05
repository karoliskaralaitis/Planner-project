package com.karalaitis.planner.goals;

import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
public class GoalController {

    private GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService){
        this.goalService = goalService;
    }

    @GetMapping("/goals/create")
    public String sayHello(Model model){
        model.addAttribute("goal", new Goal());
        return "goals";
    }

    @PostMapping("/goals/create")
    public String createAGoal(Goal goal) {
        goalService.saveGoal(goal);
        System.out.println("In database:");
        goalService.getAllGoals().forEach(System.out::println);
        return "hello";
    }
}

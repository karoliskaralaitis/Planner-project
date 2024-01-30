package com.karalaitis.planner;

import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.GoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
public class FirstController {

    private GoalsService goalsService;

    @Autowired
    public FirstController(GoalsService goalsService){
        this.goalsService = goalsService;
    }

    @GetMapping("/goals/create")
    public String sayHello(Model model){
        model.addAttribute("goal", new Goal());
        return "goals";
    }

    @PostMapping("/goals/create")
    public String createAGoal(Goal goal) {
        goalsService.saveGoal(goal);
        System.out.println("In database:");
        goalsService.getAllGoals().forEach(System.out::println);
        return "hello";
    }
}

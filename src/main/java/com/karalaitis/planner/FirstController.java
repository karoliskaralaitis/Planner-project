package com.karalaitis.planner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
@Controller
public class FirstController {

    @GetMapping("/goals/create")
    public String sayHello(Model model){
        model.addAttribute("goal", new Goal());
        return "goals";
    }

    @PostMapping("/goals/create")
    public String createAGoal(Goal goal) {
        System.out.println(goal);
        return "goals";
    }
}

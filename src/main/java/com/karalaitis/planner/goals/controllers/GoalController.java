package com.karalaitis.planner.goals.controllers;

import com.karalaitis.planner.HttpEndpoints;
import com.karalaitis.planner.goals.Goal;
import com.karalaitis.planner.goals.dto.GoalDto;
import com.karalaitis.planner.goals.service.GoalService;
import com.karalaitis.planner.helper.MessageService;
import lombok.extern.log4j.Log4j2;
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
import lombok.RequiredArgsConstructor;


import java.util.UUID;

@Controller
@Log4j2
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;
    private final MessageService messageService;

    @GetMapping(HttpEndpoints.GOALS_CREATE)
    public String showGoalCreationPage(Model model, String message){
        model.addAttribute("goal", Goal.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        return "goals/goalsCreate";
    }

    @GetMapping(HttpEndpoints.GOALS_UPDATE)
    public String showGoalUpdatePage(Model model, @PathVariable UUID goalId){
        model.addAttribute("goal", goalService.getGoalByUUID(goalId));
        return "goals/goalsCreate";
    }

    @PostMapping(HttpEndpoints.GOALS_CREATE)
    public String createGoal(Model model, Goal goal) {
        goalService.saveGoal(goal);
        model.addAttribute("message", "Goal added successfully!");
        return "redirect:/goals/create?message=goal.create.message.success";
    }

    @PostMapping(HttpEndpoints.GOALS_UPDATE)
    public String updateGoal(Model model, Pageable pageable, Goal goal, @PathVariable UUID goalId) {
        goalService.updateGoal(goal);
        return "redirect:/goals";
    }

    @GetMapping(HttpEndpoints.GOALS)
    public String getGoals(Model model, @PageableDefault(size = 3, sort = {"doByDate"}, direction = Sort.Direction.ASC) Pageable pageable){
        final Page<GoalDto> allGoals = goalService.getAllGoalsPage(pageable);
        model.addAttribute("goalList", allGoals);
        return "goals/goalsList";
    }

    @GetMapping(HttpEndpoints.GOALS_DELETE)
    public String deleteGoal(Model model, Pageable pageable, @PathVariable UUID goalId) {
        goalService.deleteGoalByUUID(goalId);
        return getGoals(model, pageable);
    }
}

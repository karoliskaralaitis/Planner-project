package com.karalaitis.planner.goals.controllers;

import com.karalaitis.planner.goals.dto.TaskDto;
import com.karalaitis.planner.goals.service.TaskService;
import jakarta.validation.Valid;
import com.karalaitis.planner.HttpEndpoints;
import com.karalaitis.planner.goals.dto.GoalDto;
import com.karalaitis.planner.goals.service.GoalService;
import com.karalaitis.planner.helper.MessageService;
import lombok.extern.log4j.Log4j2;
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
import org.springframework.validation.BindingResult;


import java.util.UUID;

@Controller
@Log4j2
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;
    private final MessageService messageService;
    private final TaskService taskService;

    @GetMapping(HttpEndpoints.GOALS_CREATE)
    public String showGoalCreationPage(Model model, String message){
        model.addAttribute("goalDto", GoalDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        return "goals/goalsCreate";
    }

    @GetMapping(HttpEndpoints.GOALS_UPDATE)
    public String showGoalUpdatePage(Model model, @PathVariable UUID goalId){
        model.addAttribute("goalDto", goalService.getGoalByUUID(goalId));
        return "goals/goalsCreate";
    }

    @PostMapping(HttpEndpoints.GOALS_CREATE)
    public String createGoal(Model model, @Valid GoalDto goal, BindingResult errors) {
        if (errors.hasErrors()) {
            return "goals/goalsCreate";
        }
        goalService.saveGoal(goal);
        return "redirect:/goals/create?message=goal.create.message.success";
    }

    @PostMapping(HttpEndpoints.GOALS_UPDATE)
    public String updateGoal(Model model, Pageable pageable, GoalDto goalDto, @PathVariable UUID goalId) {
        goalService.updateGoal(goalDto);
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

    @GetMapping(HttpEndpoints.GOALS_PAGE)
    public String getGoalPage(Model model, @PathVariable UUID goalId, @PageableDefault(size = 3, sort = {"taskFinishDate"}, direction = Sort.Direction.ASC) Pageable pageable){
        model.addAttribute("goalDto", goalService.getGoalByUUID(goalId));
        final Page<TaskDto> allTasks = taskService.getTasksByGoalId(goalId, pageable);
        model.addAttribute("allTasks", allTasks);
        return "goals/goalPage";
    }
}
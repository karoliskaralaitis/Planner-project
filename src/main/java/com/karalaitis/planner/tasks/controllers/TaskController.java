package com.karalaitis.planner.tasks.controllers;

import com.karalaitis.planner.HttpEndpoints;
import com.karalaitis.planner.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(HttpEndpoints.GOALS_PAGE + "/deleteTask/{taskId}")
    public String deleteTask(@PathVariable UUID taskId, RedirectAttributes redirectAttributes, Model model, Pageable pageable) {
        UUID goalId = taskService.getGoalIdByTaskId(taskId);
        taskService.deleteTaskByUUID(taskId);
        redirectAttributes.addAttribute("goalId", goalId);
        return "redirect:" + HttpEndpoints.GOALS_PAGE;
    }
}
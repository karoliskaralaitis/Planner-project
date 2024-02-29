package com.karalaitis.planner.goals.controllers;

import com.karalaitis.planner.HttpEndpoints;
import com.karalaitis.planner.helper.MessageService;
import com.karalaitis.planner.goals.dto.TaskDto;
import com.karalaitis.planner.goals.service.TaskService;
import lombok.RequiredArgsConstructor;
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
    private final MessageService messageService;

    @GetMapping(HttpEndpoints.TASK_DELETE)
    public String deleteTask(@PathVariable UUID taskId, RedirectAttributes redirectAttributes) {
        UUID goalId = taskService.getGoalIdByTaskId(taskId);
        taskService.deleteTaskByUUID(taskId);
        redirectAttributes.addAttribute("goalId", goalId);
        return "redirect:" + HttpEndpoints.GOALS_PAGE;
    }

    @GetMapping("/goals/{goalId}/page/addTask")
    public String showAddTaskButton(@PathVariable UUID goalId, Model model, String message) {
        model.addAttribute("goalId", goalId);
        model.addAttribute("taskDto", TaskDto.builder().build());
        model.addAttribute("message", messageService.getTranslatedMessage(message));
        return "goals/tasksCreate";
    }
}
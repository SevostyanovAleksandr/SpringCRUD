package com.example.CRUD.controller;
import com.example.CRUD.model.Task;
import com.example.CRUD.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// cвязывает мою страницу с написанным приложеним
@Controller
public class TaskController {

    //перейдя на страницу users будет реализовываться функционал
    private final TaskService taskService;
@Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/task")
    public String findAll(Model model) {
        List<Task> task = taskService.findAll();
        model.addAttribute("task", task);
        return "task-list";
    }

    @GetMapping(value = "/task-create")
    public String creatTaskform(Task task) {
        return "task-create";
    }

    @PostMapping(value = "/task-create")
    public String createTask( Task task) {
        taskService.saveTask((task));
        return "redirect:/task";
    }

    @GetMapping(value = "task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deletedById(id);
        return "redirect:/task";
    }
    @GetMapping(value = "/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "/task-update";
    }

    @PostMapping(value = "/task-update")
    public String updateTask (Task task){
        taskService.saveTask((task));
        return "redirect:/task";

    }
}
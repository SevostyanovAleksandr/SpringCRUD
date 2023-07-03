package com.example.CRUD.service;

import com.example.CRUD.model.Task;
import com.example.CRUD.model.User;
import com.example.CRUD.repository.TaskRepisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// бизнес логика
// некий запрос который мы будем принимать из внешнего мира
@Service

public class TaskService {
    private final TaskRepisitory taskRepisitory;
@Autowired
    public TaskService(TaskRepisitory taskRepisitory) {
        this.taskRepisitory = taskRepisitory;
    }


    public Task findById(Long id) {
        return taskRepisitory.getOne(id);
    }

    public List<Task> findAll() {
        return taskRepisitory.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepisitory.save(task);
    }

    public void deletedById(Long id) {
        taskRepisitory.deleteById(id);
    }
}


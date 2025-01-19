package br.com.quintinno.taskmanagerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.taskmanagerapi.entity.TaskEntity;
import br.com.quintinno.taskmanagerapi.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    public TaskEntity create(TaskEntity taskEntity) {
        return taskService.create(taskEntity);
    }

}

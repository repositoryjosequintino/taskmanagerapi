package br.com.quintinno.taskmanagerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.taskmanagerapi.entity.TaskEntity;
import br.com.quintinno.taskmanagerapi.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskEntity create(@RequestBody TaskEntity taskEntity) {
        return taskService.create(taskEntity);
    }

    @PostMapping("/create")
    public List<TaskEntity> createAll(@RequestBody List<TaskEntity> taskEntityList) {
        return taskService.createAll(taskEntityList);
    }

    @GetMapping
    public List<TaskEntity> findAll() {
        return taskService.findAll();
    }

}

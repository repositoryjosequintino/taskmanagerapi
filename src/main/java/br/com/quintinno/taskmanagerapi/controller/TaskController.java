package br.com.quintinno.taskmanagerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.quintinno.taskmanagerapi.entity.TaskEntity;
import br.com.quintinno.taskmanagerapi.service.TaskService;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PutMapping("/{id}")
    public TaskEntity upload(@PathVariable Long id, @RequestBody TaskEntity taskEntity) {
        taskEntity.setId(id);
        return this.taskService.upload(taskEntity);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return "Recurso excluído com sucesso!";
    }

    @PutMapping("/complete/{id}")
    public TaskEntity complete(@PathVariable Long id) {
        return this.taskService.complete(id);
    }

    @GetMapping("/complete")
    public List<TaskEntity> findTaskComplete() {
        return taskService.findTaskComplete();
    }

    @GetMapping("/incomplete")
    public List<TaskEntity> findTaskIncomplete() {
        return taskService.findTaskIncomplete();
    }

}

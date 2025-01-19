package br.com.quintinno.taskmanagerapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.quintinno.taskmanagerapi.entity.TaskEntity;
import br.com.quintinno.taskmanagerapi.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public TaskEntity create(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }

}

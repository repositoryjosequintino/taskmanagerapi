package br.com.quintinno.taskmanagerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> createAll(List<TaskEntity> taskEntityList) {
        return taskRepository.saveAll(taskEntityList);
    }

    @Transactional
    public TaskEntity upload(TaskEntity taskEntity) {
        return taskRepository.save(taskEntity);
    }
    
    @Transactional
    public void delete(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }

    @Transactional
    public TaskEntity complete(@PathVariable Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        taskEntity.setIsCompleted(true);
        return this.taskRepository.save(taskEntity);
    }

    public List<TaskEntity> findTaskComplete() {
        return taskRepository.findByIsCompleted(true);
    }

    public List<TaskEntity> findTaskIncomplete() {
        return taskRepository.findByIsCompleted(false);
    }

}

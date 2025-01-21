package br.com.quintinno.taskmanagerapi;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.quintinno.taskmanagerapi.entity.TaskEntity;
import br.com.quintinno.taskmanagerapi.repository.TaskRepository;
import br.com.quintinno.taskmanagerapi.service.TaskService;
import br.com.quintinno.taskmanagerapi.transfer.TaskRequestTransfer;
import br.com.quintinno.taskmanagerapi.transfer.TaskResponseTransfer;

public class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTaskSuccess() {
        
        TaskRequestTransfer taskRequestTransfer = new TaskRequestTransfer("Task 001", "Description of Task 001");

        TaskEntity taskEntity = TaskRequestTransfer.toEntity(taskRequestTransfer);
            taskEntity.setId(1L);
        
        when(taskRepository.save(any(TaskEntity.class))).thenReturn(new TaskEntity());

        TaskResponseTransfer taskResponseTransfer = this.taskService.create(taskRequestTransfer);

        assert(taskResponseTransfer != null);
        verify(taskRepository, times(1)).save(any(TaskEntity.class));

    }

}

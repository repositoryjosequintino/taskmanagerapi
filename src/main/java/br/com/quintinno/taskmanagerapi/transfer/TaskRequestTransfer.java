package br.com.quintinno.taskmanagerapi.transfer;

import javax.validation.constraints.NotBlank;

import br.com.quintinno.taskmanagerapi.entity.TaskEntity;

public class TaskRequestTransfer {

    @NotBlank
    private String title;

    private String description;

    public TaskRequestTransfer() {}

    public TaskRequestTransfer(@NotBlank String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static TaskEntity toEntity(TaskRequestTransfer taskRequestTransfer) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(taskRequestTransfer.getTitle());
        taskEntity.setDescription(taskRequestTransfer.getDescription());
        return taskEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

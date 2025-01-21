package br.com.quintinno.taskmanagerapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.quintinno.taskmanagerapi.transfer.TaskResponseTransfer;

@Entity
@Table(name = "tb_task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = 60, nullable = false)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted = false;

    public TaskEntity() {}

    public static TaskResponseTransfer toTranfer(TaskEntity taskEntity) {
        TaskResponseTransfer taskResponseTransfer = new TaskResponseTransfer();
            taskResponseTransfer.setId(taskEntity.getId());
            taskResponseTransfer.setTitle(taskEntity.getTitle());
            taskResponseTransfer.setDescription(taskEntity.getDescription());
        return taskResponseTransfer;
    }

    public TaskEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaskEntity other = (TaskEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

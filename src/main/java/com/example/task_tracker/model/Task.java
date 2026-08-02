package com.example.task_tracker.model;

import java.time.LocalDateTime;

public class Task {
    private Integer id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task() {}
    public Task(Integer id, String description, Status status, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {return id;}
    public String getDescription() {return description;}
    public Status getStatus() {return status;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}

    public void setId(Integer id) {this.id = id;}
    public void setDescription(String description) {this.description = description;}
    public void setStatus(Status status) {this.status = status;}
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

}

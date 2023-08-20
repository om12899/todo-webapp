package com.example.springboot.firstwebapp.todo;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Todo {

    private int id;
    private String username;

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", status=" + status +
                '}';
    }

    @Size(min=5, message = "Enter atleast 5 chars")
    private String description;

    public Todo(int id, String username, String description, LocalDate targetDate, boolean status) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private LocalDate targetDate;
    private boolean status;

}

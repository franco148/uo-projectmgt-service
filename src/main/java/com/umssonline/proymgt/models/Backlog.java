package com.umssonline.proymgt.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private Integer amountOfTasks;
    @OneToMany
    private List<Task> tasks;
    @Column(nullable = false)
    private LocalDate createdOn;
    private LocalDateTime updatedOn;

    protected Backlog() {
        this.tasks = new ArrayList<>();
    }

    public Backlog(String description) {
        this.description = description;
        this.tasks = new ArrayList<>();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmountOfTasks() {
        return amountOfTasks;
    }

    public void setAmountOfTasks(Integer amountOfTasks) {
        this.amountOfTasks = amountOfTasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks = tasks;
        //Set a Backlog to the task.
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}

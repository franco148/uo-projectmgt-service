package com.umssonline.proymgt.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Backlog {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    @Column(nullable = false)
    private Integer amountOfTasks;
    @Column(nullable = false)
    private LocalDate createdOn;
    private LocalDateTime updatedOn;

    @OneToOne(mappedBy = "backlog")
    private Project project;
    @OneToMany(mappedBy = "backlog")
    private List<SprintItem> sprintItems;
    //endregion

    //region Constructors
    protected Backlog() {
        this.sprintItems = new ArrayList<>();
    }

    public Backlog(String description) {
        this();
        this.description = description;
    }
    //endregion

    //region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<SprintItem> getSprintItems() {
        return sprintItems;
    }

    public void addSprintItem(SprintItem item) {
        this.sprintItems.add(item);
        //Set a Backlog to the task.
    }

    //endregion
}

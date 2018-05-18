package com.umssonline.proymgt.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SprintItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Priority priority;
    private User createdBy;
    private User assignedTo;
    private User updatedBy;
    private Integer estimatedTime;
    private LocalDate createdOn;
    private LocalDateTime startedOn;
    private LocalDateTime updatedOn;
    private LocalDateTime completedOn;

    protected SprintItem() {

    }

    public SprintItem(String name, String description, Priority priority, User createdBy, User assignedTo, User updatedBy, Integer estimatedTime) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.updatedBy = updatedBy;
        this.estimatedTime = estimatedTime;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDateTime getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDateTime completedOn) {
        this.completedOn = completedOn;
    }

}

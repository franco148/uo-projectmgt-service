package com.umssonline.proymgt.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, length = 30, unique = true)
    private String name;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startedOn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate completedDateEstimation;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Backlog backlog;
    @OneToMany(mappedBy = "project")
    private List<Sprint> sprints;
    //endregion

    //region Constructors
    private Project() {
        this.sprints = new ArrayList<>();
    }

    public Project(String name) {
        this();
        this.name = name;
    }
    //endregion

    //region Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDate startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDate getCompletedDateEstimation() {
        return completedDateEstimation;
    }

    public void setCompletedDateEstimation(LocalDate completedDateEstimation) {
        this.completedDateEstimation = completedDateEstimation;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
        //sprint.set(this);
    }

    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }
    //endregion
}

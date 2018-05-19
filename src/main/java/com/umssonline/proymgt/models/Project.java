package com.umssonline.proymgt.models;

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
    private LocalDate startedOn;
    private LocalDate completeDateEstimation;

    @OneToOne(fetch = FetchType.LAZY)
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

    public LocalDate getCompleteDateEstimation() {
        return completeDateEstimation;
    }

    public void setCompleteDateEstimation(LocalDate completeDateEstimation) {
        this.completeDateEstimation = completeDateEstimation;
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

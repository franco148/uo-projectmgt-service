package com.umssonline.proymgt.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    private LocalDate startedOn;
    private LocalDate completeDateEstimation;
    @OneToMany
    private List<Sprint> sprints;


    private Project() {

    }

    public Project(String name) {
        this.name = name;
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
}

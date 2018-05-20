package com.umssonline.proymgt.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sprint {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Column(nullable = false)
    private LocalDate startedOn;
    @Column(nullable = false)
    private LocalDate completedOn;
    @OneToMany(mappedBy = "sprint", orphanRemoval = true)
    private List<UserStory> userStories;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Project project;
    //endregion

    //region Constructors
    protected Sprint() {
        this.userStories = new ArrayList<>();
    }

    public Sprint(String name) {
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

    public LocalDate getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDate completedOn) {
        this.completedOn = completedOn;
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void addSprintItems(UserStory userStory) {
        this.userStories.add(userStory);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    //endregion
}

package com.umssonline.proymgt.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserStory extends SprintItem {

    //region Properties
    @ManyToOne(optional = false)
    private Backlog backlog;
    @Column(nullable = false)
    @OneToMany(mappedBy = "userStory", orphanRemoval = true)
    private Set<Task> tasks;
    //endregion

    //region Constructors
    protected UserStory() {
        this.tasks = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Backlog getBacklog() {
        return backlog;
    }

    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
    //endregion
}

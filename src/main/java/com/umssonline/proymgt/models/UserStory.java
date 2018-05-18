package com.umssonline.proymgt.models;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserStory extends SprintItem {

    private Set<Task> tasks;

    protected UserStory() {
        this.tasks = new HashSet<>();
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}

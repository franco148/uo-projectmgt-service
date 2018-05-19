package com.umssonline.proymgt.models;

import javax.persistence.*;

@Entity
public class Task extends SprintItem {

    @ManyToOne(optional = false)
    private UserStory userStory;

    protected Task() {

    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }
}

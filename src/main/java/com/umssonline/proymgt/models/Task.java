package com.umssonline.proymgt.models;

import javax.persistence.*;

@Entity
public class Task extends SprintItem {

    //region Properties
    @ManyToOne(optional = false)
    private UserStory userStory;
    //endregion

    //region Constructors
    protected Task() {

    }
    //endregion

    //region Getters & Setters
    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }
    //endregion
}

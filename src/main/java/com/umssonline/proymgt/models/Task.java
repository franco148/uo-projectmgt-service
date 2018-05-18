package com.umssonline.proymgt.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task extends SprintItem {

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

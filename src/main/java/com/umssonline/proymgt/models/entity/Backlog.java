package com.umssonline.proymgt.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"userStories"}, callSuper = false) //exclude = {"project", "userStories"}
@ToString(exclude = {"userStories"})//exclude = {"project", "userStories"}
@Data

@Entity
@Table(name = "backlogs")
public class Backlog extends BaseEntity {

    private String description;

    @NotNull(message = "Number of Tasks field can not be null.")
    @Column(nullable = false)
    private Integer amountOfTasks;

//    @NotNull(message = "Project should exist before creating a backlog.")
    //@JsonManagedReference
    //@OneToOne(mappedBy = "backlog", fetch = FetchType.LAZY)
//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private Project project;

    @OneToMany(mappedBy = "backlog")
    @JsonManagedReference
    private Set<UserStory> userStories = new HashSet<>();


    public void addSprintItem(UserStory userStory) {
        this.userStories.add(userStory);
        //Set a Backlog to the task.
    }

}

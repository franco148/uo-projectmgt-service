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

@EqualsAndHashCode(exclude = {"project", "userStories"})
@ToString(exclude = {"project", "userStories"})
@Data

@Entity
@Table(name = "backlogs")
public class Backlog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    @NotNull(message = "Number of Tasks field can not be null.")
    @Column(nullable = false)
    private Integer amountOfTasks;

    @PastOrPresent(message = "Created On date can not be future.")
    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Project should exist before creating a backlog.")
    @JsonManagedReference
    @OneToOne(mappedBy = "backlog", fetch = FetchType.LAZY)
    private Project project;

    @OneToMany(mappedBy = "backlog")
    @JsonManagedReference
    private Set<UserStory> userStories = new HashSet<>();



    public void addSprintItem(UserStory userStory) {
        this.userStories.add(userStory);
        //Set a Backlog to the task.
    }

}

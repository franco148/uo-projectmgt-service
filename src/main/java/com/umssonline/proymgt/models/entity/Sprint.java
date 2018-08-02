package com.umssonline.proymgt.models.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"userStories", "project"})
@ToString(exclude = {"userStories", "project"})
@Data

@Entity
@Table(name = "sprints")
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    private LocalDate startedOn;

    private LocalDate completedOn;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "sprint", orphanRemoval = true)
    private Set<UserStory> userStories = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Project project;



    public void addSprintItems(UserStory userStory) {
        this.userStories.add(userStory);
    }
}

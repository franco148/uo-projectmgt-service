package com.umssonline.proymgt.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"backlog", "sprints"})
@ToString(exclude = {"backlog", "sprints"})
@Data

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "Name field can not be empty.")
    @Size(max = 30, message = "Name field should have at most 30 characters.")
    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @NotNull(message = "Started On field can not be null.")
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate completedDateEstimation;


    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Backlog backlog;

    @OneToMany(mappedBy = "project")
    private Set<Sprint> sprints = new HashSet<>();



    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
        //sprint.set(this);
    }
}

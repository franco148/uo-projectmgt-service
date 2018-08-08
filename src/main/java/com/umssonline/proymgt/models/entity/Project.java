package com.umssonline.proymgt.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = {"backlog", "sprints"}, callSuper = false)
@ToString(exclude = {"backlog", "sprints"})
@Data

@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String name;

    private LocalDate completedDateEstimation;

    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "fk_backlog", nullable = false)
    //@MapsId
    private Backlog backlog;

    @JsonManagedReference
    @OneToMany(mappedBy = "project")
    private Set<Sprint> sprints = new HashSet<>();

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
        //sprint.set(this);
    }
}

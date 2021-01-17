package com.umssonline.projmgt.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//Soft delete
@SQLDelete(sql = "update projects set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = {"backlog", "sprints"}, callSuper = false)
@ToString(exclude = {"backlog", "sprints"})
@Data
@Builder

@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String name;

    private LocalDate completedDateEstimation;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_backlog", nullable = false)
    //@MapsId
    private Backlog backlog;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Set<Sprint> sprints = new HashSet<>();

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
        sprint.setProject(this);
    }
}

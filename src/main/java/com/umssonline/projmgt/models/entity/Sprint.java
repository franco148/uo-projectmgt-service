package com.umssonline.projmgt.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@SQLDelete(sql = "update sprints set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = {"userStories", "project"}, callSuper = false)
@ToString(exclude = {"userStories", "project"})
@Data

@Entity
@Table(name = "sprints")
public class Sprint extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    private boolean isActive;

    private LocalDate startedOn;

    private LocalDate completedOn;

    @JsonManagedReference
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private Set<UserStory> userStories = new HashSet<>();

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_project")
    private Project project;



    public void addSprintItems(UserStory userStory) {
        this.userStories.add(userStory);
        userStory.setSprint(this);
    }
}

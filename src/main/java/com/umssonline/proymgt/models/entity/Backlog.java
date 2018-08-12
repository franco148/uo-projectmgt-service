package com.umssonline.proymgt.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Soft delete
@SQLDelete(sql = "update backlogs set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = { "project", "userStories" }, callSuper = false)
@ToString(exclude = { "project", "userStories" })
@Data

@Entity
@Table(name = "backlogs")
public class Backlog extends BaseEntity {

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private Integer amountOfUserStories;

    @JsonManagedReference
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.ALL)
    private Set<UserStory> userStories = new HashSet<>();


    @JsonBackReference
    @OneToOne(optional = false, mappedBy = "backlog", cascade = CascadeType.ALL)
//    @MapsId
    private Project project;


    public void addSprintItem(UserStory userStory) {
        this.userStories.add(userStory);
        //Set a Backlog to the task.
        userStory.setBacklog(this);
    }

}

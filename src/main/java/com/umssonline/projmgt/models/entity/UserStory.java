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
import java.util.HashSet;
import java.util.Set;

//Soft delete
@SQLDelete(sql = "update user_stories set is_deleted=true where id=?")
//Conditions when retrieving data when it is not deleted
@Where(clause = "is_deleted=false")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = { "backlog", "sprint", "tasks" }, callSuper = false)
@ToString(exclude = { "backlog", "sprint", "tasks" })
@Data

@Entity
@Table(name = "user_stories")
public class UserStory extends SprintItem {

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_backlog")
    private Backlog backlog;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fk_sprint")
    private Sprint sprint;

    @JsonManagedReference
    @OneToMany(mappedBy = "userStory", orphanRemoval = true)
    private Set<Task> tasks = new HashSet<>();


    public void addTask(Task task) {
        tasks.add(task);
        task.setUserStory(this);
    }
}

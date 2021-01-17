package com.umssonline.projmgt.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(exclude = { "userStory" }, callSuper = false)
@ToString(exclude = { "userStory" })
@Data

@Entity
public class Task extends SprintItem {

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_userStory")
    private UserStory userStory;

}

package com.umssonline.projmgt.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Builder

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    @Column(nullable = false)
    private boolean isDeleted;

}

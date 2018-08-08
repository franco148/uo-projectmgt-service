package com.umssonline.proymgt.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter

@MappedSuperclass
public abstract class SprintItem extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Priority priority;

    @OneToOne(fetch = FetchType.LAZY)
    private User assignedTo;

    private Integer estimatedTime;

    @Column(updatable = false)
    private LocalDateTime startedAt;

    private LocalDateTime completedAt;

}
